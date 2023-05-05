package com.esi.candidacyservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.candidacyservice.candidacies.model.Candidacy;
import com.esi.candidacyservice.candidacies.repository.CandidacyRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadProductsData(CandidacyRepository candidacyRepository) {
        return args -> {
            Candidacy candidacy1 = new Candidacy();
			candidacy1.setCandidacyid(1);
			candidacy1.setDate("2022-03-14");
            candidacy1.setUserid(2);
			candidacy1.setStatus("Approved");
			candidacy1.setProperty("ABCD");
	

			candidacyRepository.save(candidacy1);

			
        };
    }
}