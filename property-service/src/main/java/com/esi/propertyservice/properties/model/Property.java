package com.esi.propertyservice.properties.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "propertyable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Property
{
    @Id
    private Integer propertyid;
    private Integer size; 
    private String balcony;
    private String address;
    private Integer floor;
    private Integer rooms;
    private String parking;
    
    public Integer getPropertyid() {
        return propertyid;
    }
    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }
    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }
    public String getBalcony() {
        return balcony;
    }
    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getFloor() {
        return floor;
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }
    public Integer getRooms() {
        return rooms;
    }
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }
    public String getParking() {
        return parking;
    }
    public void setParking(String parking) {
        this.parking = parking;
    }
}
