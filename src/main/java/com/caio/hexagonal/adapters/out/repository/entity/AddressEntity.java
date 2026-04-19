package com.caio.hexagonal.adapters.out.repository.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AddressEntity {

    private String street;
    private String city;
    private String state;
}
