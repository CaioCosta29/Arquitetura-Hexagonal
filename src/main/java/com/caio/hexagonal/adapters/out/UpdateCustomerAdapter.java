package com.caio.hexagonal.adapters.out;

import com.caio.hexagonal.adapters.out.repository.CustomerRepository;
import com.caio.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.caio.hexagonal.application.core.domain.Customer;
import com.caio.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer update(Customer customer) {
        var customerEntity = customerRepository.save(customerEntityMapper.toCostumerEntity(customer));

        return customerEntityMapper.toCustomer(customerEntity);
    }
}
