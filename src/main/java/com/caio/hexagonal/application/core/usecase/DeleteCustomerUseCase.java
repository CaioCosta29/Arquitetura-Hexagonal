package com.caio.hexagonal.application.core.usecase;

import com.caio.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.caio.hexagonal.application.ports.out.DeleteCustomerOutputPort;
import com.caio.hexagonal.application.ports.out.GetCustomerByIdOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;
    private final GetCustomerByIdOutputPort getCustomerByIdOutputPort;

    public DeleteCustomerUseCase(DeleteCustomerOutputPort deleteCustomerOutputPort, GetCustomerByIdOutputPort getCustomerByIdOutputPort) {
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
        this.getCustomerByIdOutputPort = getCustomerByIdOutputPort;
    }

    @Override
    public void delete(Long id) {
        getCustomerByIdOutputPort.get(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        deleteCustomerOutputPort.delete(id);
    }
}
