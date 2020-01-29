package com.customer.app.business;

import com.customer.app.models.Bank;
import com.customer.app.models.Customer;
import com.customer.app.util.ICRUD;

import reactor.core.publisher.Mono;

public interface ICustomerService extends ICRUD<Customer>{
	Mono<Customer> buscarPorCodigoTipoClienteYCodigoTipoBanco(Integer customerTypeCode, Integer codeBank);
	Mono<Bank> buscarBancoPorCodigo(Integer bankCode);

}
