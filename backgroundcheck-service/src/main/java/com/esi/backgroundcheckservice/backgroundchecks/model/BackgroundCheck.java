package com.esi.backgroundcheckservice.backgroundchecks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "backgroundchecktable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor 

public class BackgroundCheck
{
    @Id
    private Integer backgroundCheckid;
    private String date;
    
    
    public Integer getBackgroundCheckid() {
        return backgroundCheckid;
    }
    public void setBackgroundCheckid(Integer backgroundCheckid) {
        this.backgroundCheckid = backgroundCheckid;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
