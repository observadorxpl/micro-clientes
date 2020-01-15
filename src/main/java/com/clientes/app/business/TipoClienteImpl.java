package com.clientes.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientes.app.models.TipoCliente;
import com.clientes.app.repository.ITipoClienteRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class TipoClienteImpl implements ITipoClienteService{

	@Autowired
	private ITipoClienteRepository TipoClienteRepo;
	
	@Override
	public Flux<TipoCliente> findAll() {
		return TipoClienteRepo.findAll();
	}

	@Override
	public Mono<TipoCliente> finById(String id) {
		return TipoClienteRepo.findById(id);
	}

	@Override
	public Mono<TipoCliente> save(TipoCliente t) {
		return TipoClienteRepo.save(t);
	}

	@Override
	public Mono<Void> delete(TipoCliente t) {
		return TipoClienteRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return TipoClienteRepo.deleteById(id);
	}
	
	
}