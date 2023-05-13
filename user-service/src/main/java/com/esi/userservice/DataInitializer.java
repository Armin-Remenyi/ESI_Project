package com.esi.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.userservice.users.model.User;
import com.esi.userservice.users.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;


import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner loadProductsData(UserRepository userRepository) {
        return args -> {
            User user1 = new User();
            user1.setFirstName("Ingmar");
            user1.setLastName("Bingmar");
            user1.setPhoneNumber(123456);
            user1.setEmail("ingbing@gmail.com");
            user1.setPassword(passwordEncoder.encode("Ingmar"));
            user1.setRoles("LANDLORD");
            user1.setCreated(LocalDate.of(2023, 1, 1));

            userRepository.save(user1);

            User user2 = new User();
            user2.setFirstName("Steve");
            user2.setLastName("Noman");
            user2.setPhoneNumber(121212);
            user2.setEmail("steve123@gmail.com");
            user1.setPassword(passwordEncoder.encode("Steve"));
            user2.setRoles("TENANT");
            user2.setCreated(LocalDate.of(2022, 6, 22));

            userRepository.save(user2);
        };
    }
}