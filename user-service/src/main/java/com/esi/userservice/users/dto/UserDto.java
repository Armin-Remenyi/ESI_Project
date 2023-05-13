package com.esi.userservice.users.dto;

import java.time.LocalDate;
import java.util.UUID;

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

    @Id
    private UUID userId;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private LocalDate created;
    private String password;
    
}
