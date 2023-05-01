package com.esi.handoverservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.handoverservice.handovers.model.Handover;
import com.esi.handoverservice.handovers.repository.HandoverRepository;


@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadProductsData(HandoverRepository handoverRepository) {
        return args -> {
            Handover handover1 = new Handover();
			handover1.setHandoverid(1);
			handover1.setDate("2023-03-14");
            handover1.setKeys("Yes");
			handover1.setColdwater("Yes");
			handover1.setHotwater("No");
			handover1.setStatus("Waiting");
			handover1.setSignatures("Waiting");

			handoverRepository.save(handover1);

			Handover handover2 = new Handover();
			handover2.setHandoverid(2);
			handover2.setDate("2023-02-14");
            handover2.setKeys("No");
			handover2.setColdwater("Yes");
			handover2.setHotwater("Yes");
			handover2.setStatus("Waiting");
			handover2.setSignatures("Waiting");

			handoverRepository.save(handover2);
        };
    }
}