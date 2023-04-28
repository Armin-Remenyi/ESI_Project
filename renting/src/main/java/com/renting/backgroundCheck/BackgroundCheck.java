package com.renting.backgroundCheck;

import java.time.LocalDate;

public class BackgroundCheck
{
    private Integer backgroundCheckid;
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
    public BackgroundCheck(Integer backgroundCheckid, LocalDate date) {
        this.backgroundCheckid = backgroundCheckid;
        this.date = date;
    }

    
    
}
