package com.esi.signingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.signingservice.signing.model.Signing;
import com.esi.signingservice.signing.repository.SigningRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadProductsData(SigningRepository signingRepository) {
        return args -> {
            Signing signing1 = new Signing();
			signing1.setSigningId(1);
            signing1.setTenantSignDate("2022-03-14");
			signing1.setLandlordSignDate("2022-03-14");
			signing1.setDocument("pdf");
			signing1.setTenantSign("Signed");
			signing1.setLandlordSign("Signed");

			signingRepository.save(signing1);

			Signing signing2 = new Signing();
			signing2.setSigningId(2);
            signing2.setTenantSignDate("2023-03-14");
			signing2.setLandlordSignDate("2023-03-14");
			signing2.setDocument("pdf");
			signing2.setTenantSign("Signed");
			signing2.setLandlordSign("Signed");

			signingRepository.save(signing2);

        };
    }
}