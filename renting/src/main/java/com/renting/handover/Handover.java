package com.renting.handover;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "handovertable")
public class Handover
{
    @Id
    private Integer handoverid;

    @Column
    private LocalDate date; 
    private String keys;
    private String coldwater;
    private String hotwater;
    private String status;
    private String signatures;

    public Integer getHandoverid() {
        return handoverid;
    }
    public void setHandoverid(Integer handoverid) {
        this.handoverid = handoverid;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getKeys() {
        return keys;
    }
    public void setKeys(String keys) {
        this.keys = keys;
    }
    public String getColdwater() {
        return coldwater;
    }
    public void setColdwater(String coldwater) {
        this.coldwater = coldwater;
    }
    public String getHotwater() {
        return hotwater;
    }
    public void setHotwater(String hotwater) {
        this.hotwater = hotwater;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getParking() {
        return signatures;
    }
    public void setParking(String signatures) {
        this.signatures = signatures;
    }
    public Handover(Integer handoverid, LocalDate date, String keys, String coldwater, String hotwater, String status,
            String signatures) {
        this.handoverid = handoverid;
        this.date = date;
        this.keys = keys;
        this.coldwater = coldwater;
        this.hotwater = hotwater;
        this.status = status;
        this.signatures = signatures;
    }
    public Handover() {
    }
    public Handover(Integer handoverid) {
        this.handoverid = handoverid;
    }
}
