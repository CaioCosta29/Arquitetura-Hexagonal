package com.caio.hexagonal.adapters.in.controller;

import com.caio.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.caio.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.caio.hexagonal.adapters.in.controller.request.CustomerUpdateRequest;
import com.caio.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.caio.hexagonal.application.core.domain.Customer;
import com.caio.hexagonal.application.ports.in.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerContoller {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private GetAllCustomersInputPort getAllCostumersInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private GetCustomerByIdInputPort getCostumerByIdInputPort;

    @Autowired
    private DeleteCustomerInputPort deleteCustomerInputPort;

    @PostMapping
    public ResponseEntity<CustomerResponse> insert(@RequestBody @Valid CustomerRequest customerRequest) {

        var customer = insertCustomerInputPort.insert(customerMapper.toCustomer(customerRequest), customerRequest.getZipCode());
        var customerResponse = customerMapper.toCustomerResponse(customer);

        URI uri = URI.create("/api/v1/customers/" + customer.getId());

        return ResponseEntity.created(uri).body(customerResponse);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        var customers = getAllCostumersInputPort.getAll();

        var customersResponse = customers.stream()
                .map(customer -> customerMapper.toCustomerResponse(customer))
                .toList();

        return ResponseEntity.ok().body(customersResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        var customer = getCostumerByIdInputPort.get(id);

        var customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomers(
                @PathVariable Long id,
                @RequestBody @Valid CustomerUpdateRequest customerUpdateRequest) {

        Customer customer = customerMapper.toCustomer(customerUpdateRequest);
        customer.setId(id);

        var customerResponse = updateCustomerInputPort.update(customer, customerUpdateRequest.getZipCode());

        return ResponseEntity.ok().body(customerMapper.toCustomerResponse(customerResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteCustomerInputPort.delete(id);

        return ResponseEntity.noContent().build();
    }
}
