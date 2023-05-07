package com.esi.listingservice.listing.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "listingtable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor 

public class Listing
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

}
