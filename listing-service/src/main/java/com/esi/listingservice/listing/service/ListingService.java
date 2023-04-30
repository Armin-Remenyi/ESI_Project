package com.esi.listingservice.listing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.esi.listingservice.listing.model.Listing;
import com.esi.listingservice.listing.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ListingService {

    @Autowired
    ListingRepository listingRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Listing> getAllListings() {
        List<Listing> listings = new ArrayList<>();
        listingRepository.findAll().forEach(listings::add);
        return listings;
    }

    public Optional<Listing> getListing(Integer listingId) {
        return listingRepository.findById(listingId);
    }

    public void addListing(Listing listing) {
        listingRepository.save(listing);
    }

    // To be solved by students
    public void updateListing(Integer listingId, Listing listing) {

    }

    public void deleteHandover(Integer listingId) {
        listingRepository.deleteById(listingId);
    }
}
