package com.renting.signing;

import java.time.LocalDate;

public class Signing
{
    private Integer signingId;
    private LocalDate tenantSignDate;
    private LocalDate landlordSignDate; 
    private String document;
    private String tenantSign;
    private String landlordSign;
    
    public Integer getSigningId() {
        return signingId;
    }
    public void setSigningId(Integer signingId) {
        this.signingId = signingId;
    }
    public LocalDate getTenantSignDate() {
        return tenantSignDate;
    }
    public void setTenantSignDate(LocalDate tenantSignDate) {
        this.tenantSignDate = tenantSignDate;
    }
    public LocalDate getLandlordSignDate() {
        return landlordSignDate;
    }
    public void setLandlordSignDate(LocalDate landlordSignDate) {
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
    public Signing() {
    }
    public Signing(Integer signingid, LocalDate tenantSignDate, LocalDate landlordSignDate, String document,
            String tenantSign, String landlordSign) {
        this.signingId = signingid;
        this.tenantSignDate = tenantSignDate;
        this.landlordSignDate = landlordSignDate;
        this.document = document;
        this.tenantSign = tenantSign;
        this.landlordSign = landlordSign;
    }
    
}
