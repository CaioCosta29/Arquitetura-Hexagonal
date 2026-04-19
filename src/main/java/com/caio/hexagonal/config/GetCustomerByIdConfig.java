package com.caio.hexagonal.config;

import com.caio.hexagonal.adapters.out.GetCustomerByIdAdapter;
import com.caio.hexagonal.application.core.usecase.GetCostumerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetCustomerByIdConfig {

    @Bean
    public GetCostumerByIdUseCase getCostumerByIdUseCase (
            GetCustomerByIdAdapter getCustomerByIdAdapter
    ) {
        return new GetCostumerByIdUseCase(getCustomerByIdAdapter);
    }
}
