package com.customer.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.models.Customer;
@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String>{
	
}
