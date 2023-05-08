package com.esi.listingservice.listing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.esi.listingservice.listing.model.Listing;
import com.esi.listingservice.listing.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.listingservice.listing.dto.ListingDto;

import lombok.extern.slf4j.Slf4j;

import lombok.RequiredArgsConstructor;

@Service
@Slf4j
@RequiredArgsConstructor
public class ListingService {

    @Autowired
    ListingRepository listingRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;


    private final KafkaTemplate<String, ListingDto> kafkaTemplate;

    public List<ListingDto> getAllListings() {
        List<Listing> listings = new ArrayList<>();
        listingRepository.findAll().forEach(listings::add);
        return listings.stream().map(this::mapToListingDto).toList();
    }

    private ListingDto mapToListingDto(Listing listing) {
        return ListingDto.builder()
                .listingId(listing.getListingId())
                .propertyId(listing.getPropertyId())
                .contractId(listing.getContractId())
                .price(listing.getPrice())
                .description(listing.getDescription())
                .size(listing.getSize())
                .status(listing.getStatus())
                .build();
    }
    public Optional<ListingDto> getListing(Integer listingId) {
        Optional<Listing> listing = listingRepository.findById(listingId);
        return listing.map(this::mapToListingDto);
    }

    public List<ListingDto> getAllListingsByPropertyId(Integer propertyId) {
        List<Listing> listings = new ArrayList<>(listingRepository.findByPropertyId(propertyId));
        return listings.stream().map(this::mapToListingDto).toList();
    }

    public void addListing(ListingDto listingDto) {
        Listing listing = Listing.builder()
                .listingId(listingDto.getListingId())
                .propertyId(listingDto.getPropertyId())
                .contractId(listingDto.getContractId())
                .price(listingDto.getPrice())
                .description(listingDto.getDescription())
                .size(listingDto.getSize())
                .status(listingDto.getStatus())
                .build();
        listingRepository.save(listing);
        kafkaTemplate.send("ListingCreationTopic", listingDto);
        log.info("Listing {} is added to the Database", listing.getListingId());
    }

    public void updateListing(Integer listingId, ListingDto listingDto) {
        Listing listing = Listing.builder()
                .listingId(listingDto.getListingId())
                .propertyId(listingDto.getPropertyId())
                .contractId(listingDto.getContractId())
                .price(listingDto.getPrice())
                .description(listingDto.getDescription())
                .size(listingDto.getSize())
                .status(listingDto.getStatus())
                .build();
        listingRepository.save(listing);

        Optional<ListingDto> listingGet = listingRepository.findById(listingId).map(this::mapToListingDto);
        if (listingGet.isPresent() && !listingGet.get().getStatus().equals(listing.getStatus())) {
            kafkaTemplate.send("ListingStatusChangingTopic", listingDto);
        }

        log.info("Listing {} is updated", listing.getListingId());
    }

    public void deleteListing(Integer listingId) {
        listingRepository.deleteById(listingId);
        log.info("A Listing has been deleted");
    }
};
