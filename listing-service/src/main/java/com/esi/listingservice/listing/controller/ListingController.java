package com.esi.listingservice.listing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.esi.listingservice.listing.dto.ListingDto;
import com.esi.listingservice.listing.model.Listing;
import com.esi.listingservice.listing.service.ListingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ListingController {

    @Autowired
    private ListingService listingService;

    private List<Listing> listings = new ArrayList<>(Arrays.asList(
            new Listing(1, 1, 450, "Apartment available from 01.05", 33.2, "ACTIVE"),
            new Listing(2, 2, 670, "Pets allow", 50.0, "NOT_ACTIVE")));


    @GetMapping("/listing")
    public List<ListingDto> getAllListings() {
        return listingService.getAllListings();
    }

    @GetMapping("/listing/{listingId}")
    public Optional <ListingDto> getListing(@PathVariable Integer listingId) {
        return listingService.getListing(listingId);
    }

    @PostMapping("/listing")
    public void addListing(@RequestBody ListingDto listingDto) {
        listingService.addListing(listingDto);
    }

    @PutMapping("/listing/{listingId}")
    public void updateListing(@RequestBody ListingDto listingDto, @PathVariable Integer listingId) {
        listingService.updateListing(listingId, listingDto);
    }

    @DeleteMapping("/listing/{listingId}")
    public void deleteListing(@PathVariable Integer listingId) {
        listingService.deleteListing(listingId);
    }
}
