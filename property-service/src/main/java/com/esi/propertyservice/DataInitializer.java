package com.esi.propertyservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.propertyservice.properties.model.Property;
import com.esi.propertyservice.properties.repository.PropertyRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadProductsData(PropertyRepository propertyRepository) {
        return args -> {
            Property property1 = new Property();
			property1.setPropertyid(1);
            property1.setSize(44);
			property1.setBalcony("No");
			property1.setAddress("Tartu mnt 11");
			property1.setFloor(8);
			property1.setRooms(2);
			property1.setParking("Street");

			propertyRepository.save(property1);

			Property property2 = new Property();
			property2.setPropertyid(2);
            property2.setSize(120);
			property2.setBalcony("Yes");
			property2.setAddress("Tartu mnt 12");
			property2.setFloor(4);
			property2.setRooms(4);
			property2.setParking("Garage");

			propertyRepository.save(property2);
        };
    }
}