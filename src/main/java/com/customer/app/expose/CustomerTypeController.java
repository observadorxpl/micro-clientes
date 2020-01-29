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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "Customer Microservice")
@RequestMapping("/customers-type")
public class CustomerTypeController {
	@Autowired
	private ICustomerTypeService customerTypeService;

	@GetMapping
	@ApiOperation(value = "Find all customer's type", notes="Find all customer's type")
	public Flux<CustomerType> findAllCustomersType() {
		return customerTypeService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find a customer's type", notes="Find one customer's type by id")
	public Mono<CustomerType> findCustomerType(@PathVariable String id) {
		return customerTypeService.finById(id);
	}

	@PostMapping
	@ApiOperation(value = "Save a customer's type", notes="Save and return a customer's type")
	public Mono<CustomerType> saveCustomerType(@RequestBody CustomerType customerType) {
		return customerTypeService.save(customerType);
	}

	@PutMapping
	@ApiOperation(value = "Update a customer's type", notes="Update and return a customer's type")
	public Mono<CustomerType> updateCustomerType(@RequestBody CustomerType customerType) {
		return customerTypeService.save(customerType);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a customer's type", notes="Delete a customer's type by id")
	public Mono<Void> deleteCustomerType(@PathVariable String id){
		return customerTypeService.deleteById(id);
	}
}
