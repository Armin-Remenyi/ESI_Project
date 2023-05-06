package com.esi.contractservice.contracts.dto;

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
    private Integer price;
    private String description;
    private Double size;
    private String status;
    
    public ListingDto(Integer listingId)
    {
        this.listingId = listingId;
    }
    
}
