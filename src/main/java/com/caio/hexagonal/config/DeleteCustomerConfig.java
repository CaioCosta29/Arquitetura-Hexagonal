package com.caio.hexagonal.config;

import com.caio.hexagonal.adapters.out.DeleteCustomerAdapter;
import com.caio.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.caio.hexagonal.adapters.out.GetCustomerByIdAdapter;
import com.caio.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.caio.hexagonal.application.core.usecase.DeleteCustomerUseCase;
import com.caio.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.caio.hexagonal.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase (
            DeleteCustomerAdapter deleteCustomerAdapter,
            GetCustomerByIdAdapter getCustomerByIdAdapter
    ) {
        return new DeleteCustomerUseCase(deleteCustomerAdapter, getCustomerByIdAdapter);
    }
}
