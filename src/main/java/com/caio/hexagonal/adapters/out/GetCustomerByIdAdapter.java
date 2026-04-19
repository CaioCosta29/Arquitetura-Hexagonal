package com.caio.hexagonal.adapters.out;

import com.caio.hexagonal.adapters.out.repository.CustomerRepository;
import com.caio.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.caio.hexagonal.application.core.domain.Customer;
import com.caio.hexagonal.application.ports.out.GetCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCustomerByIdAdapter implements GetCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> get(Long id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
