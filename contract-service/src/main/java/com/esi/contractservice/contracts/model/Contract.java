package com.esi.contractservice.contracts.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "contracttable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor 


public class Contract
{
    @Id
    private Integer contractid;
    private Integer tenantid;
    private Integer landlordid;
    private Integer propertyid;
    private Integer listingid;
    @Nullable
    private Integer handoverid;
    private String pets;
    private String status;
    private String signing;
    private Integer price;
}
