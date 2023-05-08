package com.esi.handoverservice.handovers.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto generate key
    private Integer handoverid;
    private String date; 
    private String keys;
    private String coldwater;
    private String hotwater;
    private String status;
    private String signatures;
}
