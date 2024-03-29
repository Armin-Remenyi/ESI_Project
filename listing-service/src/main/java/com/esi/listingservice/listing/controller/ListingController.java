package com.esi.listingservice.listing.controller;

import java.util.List;
import java.util.Optional;

import com.esi.listingservice.listing.dto.ListingDto;
import com.esi.listingservice.listing.service.ListingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping("/listing")
    public List<ListingDto> getAllListings() {
        return listingService.getAllListings();
    }

    @GetMapping("/listing/{listingId}")
    public Optional<ListingDto> getListing(@PathVariable Integer listingId) {
        return listingService.getListing(listingId);
    }

    @GetMapping("/listing/properties/{propertyId}")
    public List<ListingDto> getAllListingsByPropertyId(@PathVariable Integer propertyId) {
        return listingService.getAllListingsByPropertyId(propertyId);
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
