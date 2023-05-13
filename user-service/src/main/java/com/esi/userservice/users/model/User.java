package com.esi.userservice.users.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "usertable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private UUID userId;
    @Column(unique = true)
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    private LocalDate created;
    private String password;
    private String roles;
}
