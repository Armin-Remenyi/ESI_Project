package com.renting.candidacy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Candidacy
{
    private Integer candidacyid;
    private Integer tenantid;
    private Integer propertyid;
    private BigDecimal candidateScore; 
    private LocalDate date;
    private String status;
    
    public Integer getCandidacyid() {
        return candidacyid;
    }
    public void setCandidacyid(Integer candidacyid) {
        this.candidacyid = candidacyid;
    }
    public Integer getTenantid() {
        return tenantid;
    }
    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }
    public Integer getPropertyid() {
        return propertyid;
    }
    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }
    public BigDecimal getCandidateScore() {
        return candidateScore;
    }
    public void setCandidateScore(BigDecimal candidateScore) {
        this.candidateScore = candidateScore;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Candidacy() {
    }
    public Candidacy(Integer candidacyid, Integer tenantid, Integer propertyid, BigDecimal candidateScore,
            LocalDate date, String status) {
        this.candidacyid = candidacyid;
        this.tenantid = tenantid;
        this.propertyid = propertyid;
        this.candidateScore = candidateScore;
        this.date = date;
        this.status = status;
    }
}
