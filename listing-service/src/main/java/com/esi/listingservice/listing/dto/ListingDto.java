package com.esi.listingservice.listing.dto;

import jakarta.annotation.Nullable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListingDto
{
    @Id
    private Integer listingId;
    private Integer propertyId;
    @Nullable
    private Integer contractId;
    private Integer price;
    private String description;
    private Double size;
    private String status;
    
    public ListingDto(Integer listingId)
    {
        this.listingId = listingId;
    }
    
}
