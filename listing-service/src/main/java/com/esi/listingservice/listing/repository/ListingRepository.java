package com.esi.listingservice.listing.repository;

import com.esi.listingservice.listing.model.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListingRepository extends CrudRepository<Listing, Integer> {
    List<Listing> findByPropertyId(Integer propertyId);

}
