package com.esi.candidacyservice.candidacies.dto;

import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HandoverDto
{
    @Id
    private Integer candidacyid;
    private String userid;
    private String property;
    private LocalDate date; 
    private String status;

    
    public CandidacyDto(Integer candidacyid) {
        this.candidacyid = candidacyid;
    }
}
