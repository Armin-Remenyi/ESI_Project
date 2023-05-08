package com.esi.candidacyservice.candidacies.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidacyDto
{
    @Id
    private Integer candidacyid;
    private Integer userid;
    private String property;
    private Integer listingid;
    private String date;
    private String status;

    
    public CandidacyDto(Integer candidacyid) {
        this.candidacyid = candidacyid;
    }
}
