package com.caio.hexagonal.application.core.usecase;

import com.caio.hexagonal.application.core.domain.Customer;
import com.caio.hexagonal.application.ports.in.GetAllCustomersInputPort;
import com.caio.hexagonal.application.ports.out.GetAllCustomersOutputPort;
import com.caio.hexagonal.application.ports.out.GetCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetAllCostumersUseCase implements GetAllCustomersInputPort {

    private final GetAllCustomersOutputPort getAllCustomersOutputPort;

    public GetAllCostumersUseCase(GetAllCustomersOutputPort getAllCustomersOutputPort) {
        this.getAllCustomersOutputPort = getAllCustomersOutputPort;
    }

    @Override
    public List<Customer> getAll() {
        return getAllCustomersOutputPort.getAll();
    }
}
