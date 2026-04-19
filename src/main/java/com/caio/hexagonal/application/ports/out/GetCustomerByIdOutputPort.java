package com.caio.hexagonal.application.ports.out;

import com.caio.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface GetCustomerByIdOutputPort {

    Optional<Customer> get(Long id);
}
