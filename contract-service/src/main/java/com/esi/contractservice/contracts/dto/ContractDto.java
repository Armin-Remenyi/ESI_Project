package com.esi.contractservice.contracts.dto;

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

public class ContractDto {
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

    public ContractDto(Integer contractid) {
        this.contractid = contractid;
    }

}
