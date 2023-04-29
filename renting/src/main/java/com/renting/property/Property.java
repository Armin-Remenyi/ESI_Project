package com.renting.property;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "propertyable")
public class Property
{
    @Id
    private Integer propertyid;

    @Column
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
    public Property() {
    }
    public Property(Integer propertyid, Integer size, String balcony, String address, Integer floor, Integer rooms,
            String parking) {
        this.propertyid = propertyid;
        this.size = size;
        this.balcony = balcony;
        this.address = address;
        this.floor = floor;
        this.rooms = rooms;
        this.parking = parking;
    }
}
