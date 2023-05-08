package com.esi.contractservice.contracts.dto;

import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private LocalDate created;

    public UserDto(Integer userId)
    {
        this.userId = userId;
    }
    
}
