package com.esi.contractservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.contractservice.contracts.model.Contract;
import com.esi.contractservice.contracts.repository.ContractRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadProductsData(ContractRepository contractRepository) {
        return args -> {
            Contract contract1 = new Contract();
			contract1.setContractid(1);
			contract1.setTenantid(2);
			contract1.setLandlordid(3);
			contract1.setPropertyid(4);
			contract1.setHandoverid(6);
            contract1.setPets("No");
			contract1.setStatus("Waiting");
			contract1.setSigning("Waiting");

			contractRepository.save(contract1);

			Contract contract2 = new Contract();
			contract2.setContractid(2);
			contract2.setTenantid(4);
			contract2.setLandlordid(5);
			contract2.setPropertyid(6);
			contract2.setHandoverid(9);
            contract2.setPets("Yes");
			contract2.setStatus("Waiting");
			contract2.setSigning("Signed");

			contractRepository.save(contract2);
        };
    }
}