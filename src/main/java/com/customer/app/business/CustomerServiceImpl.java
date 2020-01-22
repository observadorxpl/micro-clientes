package com.customer.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.models.Customer;
import com.customer.app.repository.ICustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {

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
		return customerRepo.save(t);
	}

	@Override
	public Mono<Void> delete(Customer t) {
		return customerRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return customerRepo.deleteById(id);
	}

}