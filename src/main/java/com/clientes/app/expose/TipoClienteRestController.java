package com.clientes.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.app.business.ITipoClienteService;
import com.clientes.app.models.TipoCliente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tipoClientes")
public class TipoClienteRestController {
	@Autowired
	private ITipoClienteService tipoClienteService;

	@GetMapping
	public Flux<TipoCliente> listarAllClientes() {
		return tipoClienteService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<TipoCliente> buscarCliente(@PathVariable String id) {
		return tipoClienteService.finById(id);
	}

	@PostMapping
	public Mono<TipoCliente> registrarCliente(@RequestBody TipoCliente cliente) {
		return tipoClienteService.save(cliente);
	}

	@PutMapping
	public Mono<TipoCliente> actualizarCliente(@RequestBody TipoCliente cliente) {
		return tipoClienteService.save(cliente);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminarCliente(@PathVariable String id){
		return tipoClienteService.deleteById(id);
	}
}
