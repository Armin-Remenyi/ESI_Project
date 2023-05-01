package com.esi.handoverservice.handovers.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Integer handoverid;
    private String date; 
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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
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
}
