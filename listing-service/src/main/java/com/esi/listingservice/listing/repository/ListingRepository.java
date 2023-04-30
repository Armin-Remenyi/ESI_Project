package com.esi.listingservice.listing.repository;

import com.esi.listingservice.listing.model.Listing;
import org.springframework.data.repository.CrudRepository;

public interface ListingRepository extends CrudRepository<Listing, Integer> {
    
}
