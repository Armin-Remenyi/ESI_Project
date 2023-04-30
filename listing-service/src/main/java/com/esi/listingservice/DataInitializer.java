package com.esi.listingservice;

import com.esi.listingservice.listing.model.Listing;
import com.esi.listingservice.listing.repository.ListingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadProductsData(ListingRepository listingRepository) {
        return args -> {
            Listing listing1 = new Listing();
			listing1.setListingId(1);
			listing1.setPropertyId(1);
			listing1.setPrice(450);
			listing1.setDescription("Apartment available from 01.05");
			listing1.setSize(33.2);
			listing1.setStatus("ACTIVE");

			listingRepository.save(listing1);

			Listing listing2 = new Listing();
			listing2.setListingId(2);
			listing2.setPropertyId(2);
			listing2.setPrice(500);
			listing2.setDescription("Pets allow");
			listing2.setSize(50.1);
			listing2.setStatus("ACTIVE");

			listingRepository.save(listing2);


        };
    }
}