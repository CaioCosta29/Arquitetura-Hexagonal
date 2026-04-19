package com.caio.hexagonal.config;

import com.caio.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.caio.hexagonal.adapters.out.GetCustomerByIdAdapter;
import com.caio.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.caio.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase (
            GetCustomerByIdAdapter getCustomerByIdAdapter,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(getCustomerByIdAdapter, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
