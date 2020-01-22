package com.customer.app.models;

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
@Getter @Setter
@ToString
public class CustomerType {
	@Id
	private String idCustomerType;
	
	@NotEmpty
	private String description;

	@NotEmpty
	private Integer customerTypeCode;

	public CustomerType(@NotEmpty String description, @NotEmpty Integer customerTypeCode) {
		super();
		this.description = description;
		this.customerTypeCode = customerTypeCode;
	}

	

}
