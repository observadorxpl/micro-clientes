package com.customer.app.business;

import com.customer.app.models.Customer;
import com.customer.app.util.ICRUD;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService extends ICRUD<Customer>{
	Mono<Customer> buscarPorCodigoTipoClienteYCodigoTipoBanco(Integer customerTypeCode, Integer codeBank);
	Flux<Customer> buscarBancoPorCodigo(Integer bankCode);

}
