package com.esi.listingservice.listing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.esi.listingservice.listing.model.Listing;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ListingController {
    private List<Listing> listings = new ArrayList<>(Arrays.asList(
            new Listing(1, 1, 450, "Apartment available from 01.05", 33.2, "ACTIVE"),
            new Listing(2, 2, 670, "Pets allow", 50.0, "NOT_ACTIVE")));


    @GetMapping("/listing")
    public List<Listing> getAllListings() {
        return listings;
    }

    @GetMapping("/listing/{id}")
    public Listing getListing(@PathVariable Integer id) {
        return listings.stream().filter(c -> c.getListingId().equals(id)).findFirst().get();
    }

    @PostMapping("/listing")
    public void addListing(@RequestBody Listing listing) {
        listings.add(listing);
    }

    @PutMapping("/listing/{id}")
    public void updateListing(@RequestBody Listing listing, @PathVariable Integer id) {
        for (int i = 0; i < listings.size(); i++) {
            Listing c = listings.get(i);
            if (c.getListingId().equals(id)) {
                listings.set(i, listing);
                return;
            }
        }
    }

    @DeleteMapping("/listing/{id}")
    public void deleteListing(@PathVariable Integer id) {
        listings.removeIf(c -> c.getListingId().equals(id));
    }
}
