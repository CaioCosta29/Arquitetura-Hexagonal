package com.caio.hexagonal.adapters.out.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;

    @Embedded
    private AddressEntity address;

    private String cpf;

    private Boolean isValidCpf;

}
