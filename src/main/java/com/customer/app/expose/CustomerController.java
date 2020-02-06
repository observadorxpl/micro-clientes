package com.customer.app.expose;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "Customer Microservice")
@RequestMapping("/customers")
public class CustomerController {
	private Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerService customerService;

	@GetMapping
	@ApiOperation(value = "List all customer", notes="Find all customer, customer contains customer's type")
	public Flux<Customer> findAllCustomers() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find a customer ", notes="Find a customer by id")
	public Mono<Customer> findCustomer(@PathVariable String id) {
		return customerService.finById(id);
	}
	
	@GetMapping("/code-bank/{codeBank}")
	@ApiOperation(value = "Find customers ", notes="Find customers by codeBank")
	public Flux<Customer> findBank(@PathVariable Integer codeBank) {		
		log.info("FindBank Controller codeBank: " + codeBank);
		return customerService.buscarBancoPorCodigo(codeBank);
	}

	@PostMapping
	@ApiOperation(value = "Save a customer ", notes="Save and return a customer")
	public Mono<Customer> saveCustomer(@RequestBody @Valid Customer customer) {
		return customerService.save(customer);
	}

	@PutMapping
	@ApiOperation(value = "Update a customer ", notes="Update and return a customer")
	public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a customer", notes="Delete a customer by id")
	public Mono<Void> deleteCustomer(@PathVariable String id){
		return customerService.deleteById(id);
	}
}
