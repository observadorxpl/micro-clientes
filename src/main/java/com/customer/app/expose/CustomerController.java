package com.customer.app.expose;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.business.ICustomerService;
import com.customer.app.models.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@GetMapping
	public Flux<Customer> findAllCustomers() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Customer> findCustomer(@PathVariable String id) {
		return customerService.finById(id);
	}

	@PostMapping
	public Mono<Customer> saveCustomer(@RequestBody @Valid Customer customer) {
		return customerService.save(customer);
	}

	@PutMapping
	public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteCustomer(@PathVariable String id){
		return customerService.deleteById(id);
	}
}
