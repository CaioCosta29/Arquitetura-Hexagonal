package com.caio.hexagonal.adapters.out.repository.mapper;

import com.caio.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.caio.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.caio.hexagonal.application.core.domain.Address;
import com.caio.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCostumerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

    List<Customer> toCustomerList(List<CustomerEntity> customerEntities);

    Address toAddress(AddressEntity addressEntity);

    AddressEntity toAddressEntity(Address address);
}
