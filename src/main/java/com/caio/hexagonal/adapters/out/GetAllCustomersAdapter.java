package com.caio.hexagonal.adapters.out;

import com.caio.hexagonal.adapters.out.repository.CustomerRepository;
import com.caio.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.caio.hexagonal.application.core.domain.Customer;
import com.caio.hexagonal.application.ports.out.GetAllCustomersOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllCustomersAdapter implements GetAllCustomersOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public List<Customer> getAll() {
        var customersEntity = customerRepository.findAll();
        return customersEntity.stream()
                .map(customerEntity -> customerEntityMapper.toCustomer(customerEntity))
                .toList();
    }
}
