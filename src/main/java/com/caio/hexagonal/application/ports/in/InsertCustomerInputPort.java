package com.caio.hexagonal.application.ports.in;

import com.caio.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    Customer insert(Customer customer, String zipCode);
}
