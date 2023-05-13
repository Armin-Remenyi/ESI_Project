package com.esi.userservice.users.controller;

import com.esi.userservice.jwt.JwtService;
import com.esi.userservice.users.dto.LoginDto;
import com.esi.userservice.users.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.esi.userservice.users.dto.UserDto;
import com.esi.userservice.users.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public Optional<UserDto> getUser(@PathVariable UUID userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/users/firstName/{firstName}")
    public Optional<UserDto> getUserByFirstname(@PathVariable String firstName, @RequestHeader("Authorization") String header) {

        String token = header.replace("Bearer ", "");
        log.info(" authenticate - token {} ", token);
        log.info("AAAAAAAAAAAAAAa");
        if (!jwtService.validateToken(token)) {
            log.info("BBBBBB");

            throw new UsernameNotFoundException("The user cannot be authinticated!");
        }

        return userService.getUserByFirstName(firstName);
    }

    @GetMapping("/authenticate")
    public Boolean authenticate(@RequestHeader("Authorization") String header) {
        String token = header.replace("Bearer ", "");
        log.info(" authenticate function - token {} ", token);
        return jwtService.validateToken(token);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @PutMapping("/users/{userId}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable UUID userId) {
        userService.updateUser(userDto, userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
    }


    // an end point for signing up new users
    @PostMapping("/signup")
    public User signupUser(@RequestBody UserDto user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public String logInAndGetToken(@RequestBody LoginDto loginDto) {

        if (loginDto.getFirstName() == null || loginDto.getPassword() == null) {
            throw new UsernameNotFoundException("UserName or Password is Empty");
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getFirstName(), loginDto.getPassword()));
        // If the user is authenticated we generate the token, otherwise, we throw an exception
        //log.info("authentication.isAuthenticated()  {} ", authentication);

        if (authentication.isAuthenticated()) {
            log.info("jwtService.generateToken(authRequest.getName())  {} ", jwtService.generateToken(loginDto.getFirstName()).toString());
            return jwtService.generateToken(loginDto.getFirstName());
        } else {
            throw new UsernameNotFoundException("The user cannot be authinticated!");
        }
    }

}
