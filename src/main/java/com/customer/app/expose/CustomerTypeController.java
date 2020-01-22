package com.customer.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.business.ICustomerTypeService;
import com.customer.app.models.CustomerType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers-type")
public class CustomerTypeController {
	@Autowired
	private ICustomerTypeService customerTypeService;

	@GetMapping
	public Flux<CustomerType> findAllCustomersType() {
		return customerTypeService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<CustomerType> findCustomerType(@PathVariable String id) {
		return customerTypeService.finById(id);
	}

	@PostMapping
	public Mono<CustomerType> saveCustomerType(@RequestBody CustomerType customerType) {
		return customerTypeService.save(customerType);
	}

	@PutMapping
	public Mono<CustomerType> updateCustomerType(@RequestBody CustomerType customerType) {
		return customerTypeService.save(customerType);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteCustomerType(@PathVariable String id){
		return customerTypeService.deleteById(id);
	}
}
