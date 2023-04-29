package com.esi.handoverservice.handovers.dto;

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
    private Integer handoverid;
    private LocalDate date; 
    private String keys;
    private String coldwater;
    private String hotwater;
    private String status;
    private String signatures;
    
    public HandoverDto(Integer handoverid)
    {
        this.handoverid = handoverid;
    }
    
}
