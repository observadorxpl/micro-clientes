package com.clientes.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.clientes.app.models.Cliente;
@Repository
public interface IClienteRepository extends ReactiveMongoRepository<Cliente, String>{
	
}
