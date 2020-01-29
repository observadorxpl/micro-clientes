package com.customer.app.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.models.Customer;

import reactor.core.publisher.Mono;
@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String>{
	@Query("{ 'customerType.customerTypeCode': ?0 , 'bank.codeBank': ? 1}")
	Mono<Customer> buscarPorCodigoTipoClienteYCodigoTipoBanco(Integer customerTypeCode, Integer codeBank);
}
