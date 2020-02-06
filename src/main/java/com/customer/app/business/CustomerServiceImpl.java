package com.customer.app.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.customer.app.expose.CustomerController;
import com.customer.app.models.Bank;
import com.customer.app.models.Customer;
import com.customer.app.repository.ICustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	private Logger log = LoggerFactory.getLogger(CustomerController.class);
	
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
		return customerRepo.findByCustomerType_CustomerTypeCodeAndBank_CodeBank(customerTypeCode, codeBank);
	}

	@Override
	public Flux<Customer> buscarBancoPorCodigo(Integer bankCode) {
		log.info("buscarBancoPorCodigo service bankCode: " + bankCode);
		return customerRepo.findByBank_CodeBank(bankCode);
	}

}