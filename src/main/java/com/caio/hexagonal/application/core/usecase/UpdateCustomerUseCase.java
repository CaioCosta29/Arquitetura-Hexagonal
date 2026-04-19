package com.caio.hexagonal.application.core.usecase;

import com.caio.hexagonal.application.core.domain.Customer;
import com.caio.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.caio.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.caio.hexagonal.application.ports.out.GetCustomerByIdOutputPort;
import com.caio.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {


    private final GetCustomerByIdOutputPort getCustomerByIdOutputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(GetCustomerByIdOutputPort getCustomerByIdOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.getCustomerByIdOutputPort = getCustomerByIdOutputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public Customer update(Customer customer, String zipCode) {
        getCustomerByIdOutputPort.get(customer.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        return updateCustomerOutputPort.update(customer);
    }
}
