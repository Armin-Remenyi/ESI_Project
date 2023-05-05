package com.esi.propertyservice.properties.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "propertyable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Property
{
    @Id
    private Integer propertyid;
    private Integer size; 
    private String balcony;
    private String address;
    private Integer floor;
    private Integer rooms;
    private String parking;
}
