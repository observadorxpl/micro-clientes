package com.clientes.app.models;

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
public class TipoCliente {
	@Id
	private String idTipoCliente;
	
	@NotEmpty
	private String descripcion;

	public TipoCliente(@NotEmpty String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
}
