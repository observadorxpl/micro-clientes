package com.customer.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.customer.app.models.Customer;
import com.customer.app.models.CustomerType;
import com.customer.app.repository.ICustomerRepository;
import com.customer.app.repository.ICustomerTypeRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ClientesMsApplication implements CommandLineRunner {
	@Autowired
	private ICustomerRepository customerRepo;
	@Autowired
	private ICustomerTypeRepository customerTypeRepo;
	
	@Autowired
	private ReactiveMongoTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.dropCollection(Customer.class).subscribe();
		template.dropCollection(CustomerType.class).subscribe();
		
		// REGISTRO DE TIPO DE CLIENTSE Y CLIENTES
		CustomerType tip1 = new CustomerType("Empresarial", 1);
		CustomerType tip2 = new CustomerType("Peronal", 2);
		CustomerType tip3 = new CustomerType("Persona VIP", 3);
		CustomerType tip4 = new CustomerType("PYME", 4);
		CustomerType tip5 = new CustomerType("Corporative", 5);


		Flux.just(tip1, tip2, tip3, tip4, tip5)
		.flatMap(tip -> customerTypeRepo.save(tip)).
		thenMany(
				Flux.just(new Customer("Jose Luis", "Cayo", "Acuña", "74642154", tip1), 
						new Customer("Juan", "Perez", "Aguinaldo", "73242154", tip2),
						new Customer("Alfonzo", "Gilberto", "Orio", "09983254", tip2),
						new Customer("Pepito", "Gonzales", "Polo", "84747387", tip3),
						new Customer("Rosa", "Loza", "Orozco", "54294859", tip4),
						new Customer("Yanni", "Trujillo", "Arias", "38574817", tip5)

						)
				.flatMap(cli -> customerRepo.save(cli))
			)
		.subscribe(res -> System.out.println("Cliente".concat(res.toString().concat(" " + "Registrado"))));
	}

}
