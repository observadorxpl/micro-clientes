package com.clientes.app;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.customer.app.business.ICustomerService;
import com.customer.app.business.ICustomerTypeService;
import com.customer.app.models.Bank;
import com.customer.app.models.Customer;
import com.customer.app.models.CustomerType;

import reactor.core.publisher.Mono;
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ClientesMsApplicationTests.class)
@SpringBootTest
class ClientesMsApplicationTests {
	/*
	@Value("${com.bootcamp.gateway.url}")
	private String gatewayUrlPort;
	
	@Autowired
	private WebTestClient client;
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private ICustomerTypeService serviceType;
	@Test
	void listarClientesTest() {
		client.get()
		.uri("/customers")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBodyList(Customer.class)
		.consumeWith(response -> {
			List<Customer> customers= response.getResponseBody();
			customers.forEach(c -> {
				System.out.println(c);
			});
			
			Assertions.assertThat(customers.size()>0).isTrue();
		});
	}
	
	@Test
	public void registrarClienteTest() {
		
		CustomerType customerType= serviceType.buscarPorCodigoTipoCliente(5).block();
		Bank bank = service.buscarBancoPorCodigo(101).block();
		Customer customer = new Customer("Alfredo", "Zaens", "Orio", "84848484", customerType, bank);
		
		client.post().uri("/customers")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(customer), Customer.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody(Customer.class)
		.consumeWith(response -> {
			Customer cus = response.getResponseBody();
			Assertions.assertThat(cus.getIdCustomer()).isNotEmpty();
			Assertions.assertThat(cus.getCustomerType()).isNotNull();
			Assertions.assertThat(cus.getBank()).isNotNull();
			Assertions.assertThat(cus.getFirstName()).isNotEmpty();
			Assertions.assertThat(cus.getDni()).isNotEmpty();
		});
	}
*/
}
