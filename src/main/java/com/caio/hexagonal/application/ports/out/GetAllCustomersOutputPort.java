package com.caio.hexagonal.application.ports.out;

import com.caio.hexagonal.application.core.domain.Customer;

import java.util.List;

public interface GetAllCustomersOutputPort {

    List<Customer>getAll();

}
