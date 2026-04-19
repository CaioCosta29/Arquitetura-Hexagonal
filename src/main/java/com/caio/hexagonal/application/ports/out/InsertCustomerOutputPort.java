package com.caio.hexagonal.application.ports.out;

import com.caio.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    Customer insert(Customer customer);
}
