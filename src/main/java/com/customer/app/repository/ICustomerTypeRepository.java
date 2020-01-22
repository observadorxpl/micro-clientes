package com.customer.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.models.CustomerType;

@Repository
public interface ICustomerTypeRepository extends ReactiveMongoRepository<CustomerType, String> {

}
