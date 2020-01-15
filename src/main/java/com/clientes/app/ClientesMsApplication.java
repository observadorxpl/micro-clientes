package com.clientes.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.clientes.app.models.Cliente;
import com.clientes.app.models.TipoCliente;
import com.clientes.app.repository.IClienteRepository;
import com.clientes.app.repository.ITipoClienteRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ClientesMsApplication implements CommandLineRunner {
	@Autowired
	private IClienteRepository clienteRepo;
	@Autowired
	private ITipoClienteRepository tipoClienteRepo;
	
	@Autowired
	private ReactiveMongoTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.dropCollection(Cliente.class).subscribe();
		template.dropCollection(TipoCliente.class).subscribe();
		
		// REGISTRO DE TIPO DE CLIENTSE Y CLIENTES
		TipoCliente tip1 = new TipoCliente("Empresarial");
		TipoCliente tip2 = new TipoCliente("Peronal");


		Flux.just(tip1, tip2)
		.flatMap(tip -> tipoClienteRepo.save(tip)).
		thenMany(
				Flux.just(new Cliente("Jose Luis", "Cayo", "Acuña", "74642154", tip1), 
						new Cliente("Juan", "Perez", "Aguinaldo", "73242154", tip2),
						new Cliente("Alfonzo", "Gilberto", "Orio", "11232154", tip2)
						)
				.flatMap(cli -> clienteRepo.save(cli))
			)
		.subscribe(res -> System.out.println("Cliente".concat(res.toString().concat(" " + "Registrado"))));
	}

}
