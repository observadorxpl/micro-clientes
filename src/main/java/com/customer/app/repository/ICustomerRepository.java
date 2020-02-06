package com.customer.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.models.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String>{
	Mono<Customer> findByCustomerType_CustomerTypeCodeAndBank_CodeBank(Integer customerTypeCode, Integer codeBank);

	Flux<Customer> findByBank_CodeBank(Integer codeBank);
}
