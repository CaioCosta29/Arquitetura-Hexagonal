package com.caio.hexagonal.application.core.usecase;

import com.caio.hexagonal.application.core.domain.Customer;
import com.caio.hexagonal.application.ports.in.GetCustomerByIdInputPort;
import com.caio.hexagonal.application.ports.out.GetCustomerByIdOutputPort;

public class GetCostumerByIdUseCase implements GetCustomerByIdInputPort {

    private final GetCustomerByIdOutputPort getCustomerByIdOutputPort;

    public GetCostumerByIdUseCase(GetCustomerByIdOutputPort getCustomerByIdOutputPort) {
        this.getCustomerByIdOutputPort = getCustomerByIdOutputPort;
    }

    @Override
    public Customer get(Long id) {
        return getCustomerByIdOutputPort.get (id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
