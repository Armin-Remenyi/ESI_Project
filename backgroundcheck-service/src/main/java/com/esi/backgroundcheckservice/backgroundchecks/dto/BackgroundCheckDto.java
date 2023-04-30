package com.esi.backgroundcheckservice.backgroundchecks.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor 


public class BackgroundCheckDto {
    @Id      
    private Integer backgroundCheckid;

    private LocalDate date;
    
    public BackgroundCheckDto(Integer backgroundCheckid) {
        this.backgroundCheckid = backgroundCheckid;
    }


}


