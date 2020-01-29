package com.customer.app.business;

import com.customer.app.models.CustomerType;
import com.customer.app.util.ICRUD;

import reactor.core.publisher.Mono;

public interface ICustomerTypeService extends ICRUD<CustomerType>{
	Mono<CustomerType> buscarPorCodigoTipoCliente(Integer customertypeCode);
}
