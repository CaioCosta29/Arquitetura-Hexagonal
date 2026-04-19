package com.caio.hexagonal.application.ports.in;

import com.caio.hexagonal.application.core.domain.Customer;

import java.util.List;

public interface GetAllCustomersInputPort {

    List<Customer> getAll();
}
