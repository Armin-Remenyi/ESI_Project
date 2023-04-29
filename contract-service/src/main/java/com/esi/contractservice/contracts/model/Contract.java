package com.esi.contractservice.contracts.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "contracttable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor 


public class Contract
{
    @Id
    private Integer contractid;
    private Integer tenantid;
    private Integer landlordid;
    private Integer propertyid;
    private Integer handoverid;
    private String pets;
    private String status;
    private String signing;

   
    public Integer getContractid() {
        return contractid;
    }
    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }

    public Integer getTenantid() {
        return tenantid;
    }
    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }
    public Integer getLandlordid() {
        return landlordid;
    }
    public void setLandlordid(Integer landlordid) {
        this.landlordid = landlordid;
    }
    public Integer getPropertyid() {
        return propertyid;
    }
    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }
    public Integer getHandoverid() {
        return handoverid;
    }
    public void setHandoverid(Integer handoverid) {
        this.handoverid = handoverid;
    }
    public String getPets() {
        return pets;
    }
    public void setPets(String pets) {
        this.pets = pets;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSigning() {
        return signing;
    }
    public void setSigning(String signing) {
        this.signing = signing;
    }

}
