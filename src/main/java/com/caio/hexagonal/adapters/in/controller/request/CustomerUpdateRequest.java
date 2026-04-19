package com.caio.hexagonal.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerUpdateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String zipCode;
}
