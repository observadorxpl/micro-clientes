package com.customer.app.models;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	@Id
	private String idCustomer;

	private String firstName;
	@NotEmpty
	private String lastnamePaternal;
	@NotEmpty
	private String lastnameMaternal;
	@NotEmpty
	private String dni;

	@Valid
	private CustomerType customerType;
	@Valid
	private Bank bank;

	public Customer(String firstName, @NotEmpty String lastnamePaternal, @NotEmpty String lastnameMaternal,
			@NotEmpty String dni, @Valid CustomerType customerType, @Valid Bank bank) {
		super();
		this.firstName = firstName;
		this.lastnamePaternal = lastnamePaternal;
		this.lastnameMaternal = lastnameMaternal;
		this.dni = dni;
		this.customerType = customerType;
		this.bank = bank;
	}
}
