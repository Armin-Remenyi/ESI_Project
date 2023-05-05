package com.esi.signingservice.signing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "signingtable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Signing {

    @Id
    private Integer signingId;
    private String tenantSignDate;
    private String landlordSignDate;
    private String document;
    private String tenantSign;
    private String landlordSign;
}
