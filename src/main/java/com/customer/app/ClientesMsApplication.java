package com.customer.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.customer.app.models.Bank;
import com.customer.app.models.Customer;
import com.customer.app.models.CustomerType;
import com.customer.app.repository.ICustomerRepository;
import com.customer.app.repository.ICustomerTypeRepository;

import reactor.core.publisher.Flux;
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class ClientesMsApplication implements CommandLineRunner {

	@Value("${com.bootcamp.gateway.url}")
	private String gatewayUrlPort;

	@Autowired
	private ICustomerTypeRepository customerTypeRepo;

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private ReactiveMongoTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(ClientesMsApplication.class, args);
	}
	// Metodo para generar registros de tipo de clientes, clientes.
	// Es necesario tener bancos registrados (100,101,102)
	@Override
	public void run(String... args) throws Exception {
		/*
		 template.dropCollection(Customer.class).subscribe();
		 template.dropCollection(CustomerType.class).subscribe();

		// REGISTRO DE TIPO DE CLIENTSE
		CustomerType tip1 = new CustomerType("Empresarial", 1);
		CustomerType tip2 = new CustomerType("Peronal", 2);
		CustomerType tip3 = new CustomerType("Persona VIP", 3);
		CustomerType tip4 = new CustomerType("PYME", 4);
		CustomerType tip5 = new CustomerType("Corporative", 5);

		Flux.just(tip1, tip2, tip3, tip4, tip5).flatMap(tip -> customerTypeRepo.save(tip)).subscribe();

		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
				.uri("/code-bank/100").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
					return customerRepo.save(new Customer("Alfonzo", "Gilberto", "Orio", "09983254", tip2, bank));
				}).flatMap(cus -> {
					return customerRepo
							.save(new Customer("Yanni", "Trujillo", "Arias", "38574817", tip5, cus.getBank()));
				}).subscribe();

		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
				.uri("/code-bank/101").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
					return customerRepo.save(new Customer("Juan", "Perez", "Aguinaldo", "73242154", tip2, bank));
				}).flatMap(cus -> {
					return customerRepo
							.save(new Customer("Jose Luis", "Cayo", "Acuña", "74642154", tip1, cus.getBank()));
				}).subscribe();

		WebClient.builder().baseUrl("http://" + gatewayUrlPort + "/micro-banco/bank/").build().get()
				.uri("/code-bank/102").retrieve().bodyToMono(Bank.class).log().flatMap(bank -> {
					return customerRepo.save(new Customer("Rosa", "Loza", "Orozco", "54294859", tip4, bank));
				}).flatMap(cus -> {
					return customerRepo
							.save(new Customer("Pepito", "Gonzales", "Polo", "84747387", tip3, cus.getBank()));
				}).subscribe();
				*/
	}
	
}
