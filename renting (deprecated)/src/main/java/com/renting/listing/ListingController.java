package com.renting.listing;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ListingController {

    private List<Listing> listings = new ArrayList<>(Arrays.asList(
            new Listing(1, 1, 450, "Apartment available from 01.05", 33.2, "ACTIVE"),
            new Listing(2, 2, 670, "Pets allow", 50.0, "NOT_ACTIVE")
    ));


    @GetMapping("/listing")
    public List<Listing> getAllListings() {
        return listings;
    }

    @GetMapping("/listing/{id}")
    public Listing getListing(@PathVariable Integer listingId) {
        return listings.stream().filter(c -> c.getListingId().equals(listingId)).findFirst().get();
    }

    @PostMapping("/listing")
    public void addListing(@RequestBody Listing listing) {
        listings.add(listing);
    }

    @PutMapping("/listing/{id}")
    public void updateListing(@RequestBody Listing listing, @PathVariable Integer listingId) {
        for (int i = 0; i < listings.size(); i++) {
            Listing c = listings.get(i);
            if (c.getListingId().equals(listingId)) {
                listings.set(i, listing);
                return;
            }
        }
    }

    @DeleteMapping("/listing/{id}")
    public void deleteProperty(@PathVariable Integer listingId) {
        listings.removeIf(c -> c.getListingId().equals(listingId));
    }
}
