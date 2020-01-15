package com.clientes.app.expose;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.app.business.IClienteService;
import com.clientes.app.models.Cliente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {
	@Autowired
	private IClienteService clienteService;

	@GetMapping
	public Flux<Cliente> listarAllClientes() {
		return clienteService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Cliente> buscarCliente(@PathVariable String id) {
		return clienteService.finById(id);
	}

	@PostMapping
	public Mono<Cliente> registrarCliente(@RequestBody @Valid Cliente cliente) {
		return clienteService.save(cliente);
	}

	@PutMapping
	public Mono<Cliente> actualizarCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminarCliente(@PathVariable String id){
		return clienteService.deleteById(id);
	}
}
