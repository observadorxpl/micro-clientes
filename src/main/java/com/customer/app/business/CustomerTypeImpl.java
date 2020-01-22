package com.customer.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.models.CustomerType;
import com.customer.app.repository.ICustomerTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CustomerTypeImpl implements ICustomerTypeService{

	@Autowired
	private ICustomerTypeRepository customerTypeRepo;
	
	@Override
	public Flux<CustomerType> findAll() {
		return customerTypeRepo.findAll();
	}

	@Override
	public Mono<CustomerType> finById(String id) {
		return customerTypeRepo.findById(id);
	}

	@Override
	public Mono<CustomerType> save(CustomerType t) {
		return customerTypeRepo.save(t);
	}

	@Override
	public Mono<Void> delete(CustomerType t) {
		return customerTypeRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return customerTypeRepo.deleteById(id);
	}
	
	
}