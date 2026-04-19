package com.caio.hexagonal.adapters.out;

import com.caio.hexagonal.adapters.out.repository.CustomerRepository;
import com.caio.hexagonal.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
