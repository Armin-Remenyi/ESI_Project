package com.esi.propertyservice.properties.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PropertyDto {
    @Id
    private Integer propertyid;
    private Integer size; 
    private String balcony;
    private String address;
    private Integer floor;
    private Integer rooms;
    private String parking;

    public PropertyDto(Integer propertyid)
    {
        this.propertyid = propertyid;
    }
}
