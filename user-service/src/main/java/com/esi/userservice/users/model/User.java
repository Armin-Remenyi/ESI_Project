package com.esi.userservice.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "usertable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    private Integer userid;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private LocalDate created;

    public Integer getUserId() {
        return userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // NOTE: we don't need setCreated, because 'created' initializing onc during user creation
    public LocalDate getCreated() {
        return created;
    }
}
