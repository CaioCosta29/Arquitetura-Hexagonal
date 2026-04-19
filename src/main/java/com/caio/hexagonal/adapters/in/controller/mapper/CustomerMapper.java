package com.caio.hexagonal.adapters.in.controller.mapper;

import com.caio.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.caio.hexagonal.adapters.in.controller.request.CustomerUpdateRequest;
import com.caio.hexagonal.adapters.in.controller.response.AddressResponse;
import com.caio.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.caio.hexagonal.application.core.domain.Address;
import com.caio.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

    AddressResponse toAddressResponse(Address address);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    Customer toCustomer(CustomerUpdateRequest customerUpdateRequest);
}
