package com.caio.hexagonal.config;

import com.caio.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.caio.hexagonal.adapters.out.InsertCustomerAdapter;
import com.caio.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.caio.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
