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
    private LocalDate date; 
    private String status;

    public Integer getCandidacyid() {
        return candidacyid;
    }
    public void setCandidacyid(Integer candidacyid) {
        this.candidacyid = candidacyid;
    }
    public Integer getUser() {
        return userid;
    }
    public String getProperty() {
        return property;
    }
    public void setProperty(String property) {
        this.property = property;
    }
    public void setUser(Integer userid) {
        this.userid = userid;
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
}
