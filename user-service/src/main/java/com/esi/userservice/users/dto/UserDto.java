package com.esi.userservice.users.dto;

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
    private Integer userId;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private String created;

    public UserDto(Integer userId)
    {
        this.userId = userId;
    }
    
}
