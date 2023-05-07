package com.esi.candidacyservice.candidacies.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidacytable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor 

public class Candidacy
{
    @Id
    private Integer candidacyid;
    private Integer userid;
    private String property;
    private Integer listingid;
    private String date;
    private String status;
}
