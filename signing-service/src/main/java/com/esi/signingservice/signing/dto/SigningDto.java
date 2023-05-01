package com.esi.signingservice.signing.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SigningDto {

    @Id
    private Integer signingId;
    private String tenantSignDate;
    private String landlordSignDate;
    private String document;
    private String tenantSign;
    private String landlordSign;

    public SigningDto(Integer signingId)
    {
        this.signingId = signingId;
    }
}
