package com.caio.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {

    private Long id;
    private String name;
    private String zipCode;
    private String cpf;
    private Boolean isValidCpf;
}
