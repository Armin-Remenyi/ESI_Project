package com.esi.backgroundcheckservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.backgroundcheckservice.backgroundchecks.model.BackgroundCheck;
import com.esi.backgroundcheckservice.backgroundchecks.repository.BackgroundCheckRepository;


@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadProductsData(BackgroundCheckRepository backgroundcheckRepository) {
        return args -> {
            BackgroundCheck backgroundcheck1 = new BackgroundCheck();
			backgroundcheck1.setBackgroundCheckid(1);
			backgroundcheck1.setDate("2023-03-14");
			
            backgroundcheckRepository.save(backgroundcheck1);

			
        };
    }
}