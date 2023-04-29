package src.main.java.com.esi.signingservice.signing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "signingtable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Signing {

    @Id
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
}
