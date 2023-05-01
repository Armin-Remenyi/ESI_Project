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

    public Integer getSigningId() {
        return signingId;
    }

    public void setSigningId(Integer signingId) {
        this.signingId = signingId;
    }

    public String getTenantSignDate() {
        return tenantSignDate;
    }

    public void setTenantSignDate(String tenantSignDate) {
        this.tenantSignDate = tenantSignDate;
    }

    public String getLandlordSignDate() {
        return landlordSignDate;
    }

    public void setLandlordSignDate(String landlordSignDate) {
        this.landlordSignDate = landlordSignDate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTenantSign() {
        return tenantSign;
    }

    public void setTenantSign(String tenantSign) {
        this.tenantSign = tenantSign;
    }

    public String getLandlordSign() {
        return landlordSign;
    }

    public void setLandlordSign(String landlordSign) {
        this.landlordSign = landlordSign;
    }
}
