package com.caio.hexagonal.config;

import com.caio.hexagonal.adapters.out.GetAllCustomersAdapter;
import com.caio.hexagonal.application.core.usecase.GetAllCostumersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllCustomersConfig {

    @Bean
    public GetAllCostumersUseCase getAllCostumersUseCase (
            GetAllCustomersAdapter getAllCustomersAdapter
    ) {
        return new GetAllCostumersUseCase(getAllCustomersAdapter);
    }
}
