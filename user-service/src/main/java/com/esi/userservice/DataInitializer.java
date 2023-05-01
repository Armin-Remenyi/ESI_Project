package com.esi.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.userservice.users.model.User;
import com.esi.userservice.users.repository.UserRepository;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadProductsData(UserRepository userRepository) {
        return args -> {
            User user1 = new User();
			user1.setUserid(1);;
            user1.setFirstName("Ingmar");
			user1.setLastName("Bingmar");
			user1.setPhoneNumber(123456);
			user1.setEmail("ingbing@gmail.com");
			user1.setCreated("2023-01-01");

			userRepository.save(user1);

			User user2 = new User();
			user2.setUserid(2);;
            user2.setFirstName("Steve");
			user2.setLastName("Noman");
			user2.setPhoneNumber(121212);
			user2.setEmail("steve123@gmail.com");
			user2.setCreated("2022-06-02");

			userRepository.save(user2);
        };
    }
}