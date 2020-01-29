package com.customer.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.customer.app.models.Bank;
import com.customer.app.models.Customer;
import com.customer.app.repository.ICustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Value("${com.bootcamp.gateway.url}")
	private String gatewayUrlPort;

	@Autowired
	private ICustomerRepository customerRepo;

	@Override
	public Flux<Customer> findAll() {
		return customerRepo.findAll();
	}

	@Override
	public Mono<Customer> finById(String id) {
		return customerRepo.findById(id);
	}

	@Override
	public Mono<Customer> save(Customer t) {
		return WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
				.uri(t.getBank().getIdBank()).retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
					return customerRepo.save(t);
				});
	}

	@Override
	public Mono<Void> delete(Customer t) {
		return customerRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return customerRepo.deleteById(id);
	}

	@Override
	public Mono<Customer> buscarPorCodigoTipoClienteYCodigoTipoBanco(Integer customerTypeCode, Integer codeBank) {
		return customerRepo.buscarPorCodigoTipoClienteYCodigoTipoBanco(customerTypeCode, codeBank);
	}

	@Override
	public Mono<Bank> buscarBancoPorCodigo(Integer bankCode) {
		return WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/code-bank/").build().get()
				.uri(bankCode.toString()).retrieve().bodyToMono(Bank.class).log();
	}

}