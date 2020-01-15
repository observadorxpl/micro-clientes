package com.clientes.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientes.app.models.Cliente;
import com.clientes.app.repository.IClienteRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepo;

	@Override
	public Flux<Cliente> findAll() {
		return clienteRepo.findAll();
	}

	@Override
	public Mono<Cliente> finById(String id) {
		return clienteRepo.findById(id);
	}

	@Override
	public Mono<Cliente> save(Cliente t) {
		return clienteRepo.save(t);
	}

	@Override
	public Mono<Void> delete(Cliente t) {
		return clienteRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return clienteRepo.deleteById(id);
	}

}