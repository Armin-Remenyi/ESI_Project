package com.esi.backgroundcheckservice.backgroundchecks.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "backgroundchecktable")
public class BackgroundCheck
{
    @Id
    private Integer backgroundCheckid;

    @Column(name = "date")
    private LocalDate date;
    
    
    public Integer getBackgroundCheckid() {
        return backgroundCheckid;
    }
    public void setBackgroundCheckid(Integer backgroundCheckid) {
        this.backgroundCheckid = backgroundCheckid;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public BackgroundCheck() {
    }
    public BackgroundCheck(Integer backgroundCheckid) {
        this.backgroundCheckid = backgroundCheckid;
    }
    public BackgroundCheck(Integer backgroundCheckid, LocalDate date) {
        this.backgroundCheckid = backgroundCheckid;
        this.date = date;
    }

    
    
}
