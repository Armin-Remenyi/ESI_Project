package com.esi.candidacyservice.candidacies.model;

import java.time.LocalDate;

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

public class Handover
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
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Integer getUser() {
        return userid;
    }
    public void setUser(String user) {
        this.userid = user;
    }
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

