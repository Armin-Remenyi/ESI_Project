package com.renting.listing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "listingtable")
public class Listing {

    @Id
    private Integer listingId;

    @Column
    private Integer propertyId;
    private Integer price;
    private String description;
    private Double size;
    private String status;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Listing() {
    }

    public Listing(
            Integer listingId,
            Integer propertyId,
            Integer price,
            String description,
            Double size,
            String status
    ) {
        this.listingId = listingId;
        this.propertyId = propertyId;
        this.price = price;
        this.description = description;
        this.size = size;
        this.status = status;
    }
}
