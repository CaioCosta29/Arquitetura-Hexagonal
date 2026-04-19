package com.caio.hexagonal.application.ports.out;

import com.caio.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
