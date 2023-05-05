package com.esi.handoverservice.handovers.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "handovertable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor 

public class Handover
{
    @Id
    private Integer handoverid;
    private String date; 
    private String keys;
    private String coldwater;
    private String hotwater;
    private String status;
    private String signatures;
}
