package com.renting.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {


    @Autowired
    ListingRepository listingRepository;

    public List<Listing> getAllListings()
    {
        List<Listing> listings = new ArrayList<>();
        listingRepository.findAll().forEach(listings::add);
        return listings;
    }

    public Optional<Listing> getListing(Integer listingId){
        return listingRepository.findById(listingId);
    }

    public void addListing(Listing listing) {
        listingRepository.save(listing);
    }

    // TODO: To be solved by students
    public void updateListing(Integer listingId, Listing listing) {

    }

    // TODO: To be solved by students
    public void deleteListing(Integer listingId) {
        listingRepository.deleteById(listingId);
    }



}
