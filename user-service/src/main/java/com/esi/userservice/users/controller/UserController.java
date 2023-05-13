package com.esi.userservice.users.controller;

import com.esi.userservice.jwt.JwtService;
import com.esi.userservice.users.model.User;
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

//@CrossOrigin(origins = "*")
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
    public Optional <UserDto> getUser(@PathVariable UUID userId) {
        return userService.getUser(userId);
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
    public User signupUser(@RequestBody UserDto user){
        return userService.addUser(user);
    }


    // a new end-point that allows users to authenticate themselves and generate the jwt token
    //This endpoint will receive the userDto, authenticate her/him with existing users in the database, then if authenticated, it will create the jwt
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody UserDto userDto) {

        // authenticationManager.authenticate attempts to authenticate the passed Authentication object, returning a fully populated Authentication object (including granted authorities) if successful.
        // UsernamePasswordAuthenticationToken can be used by the authenticationManager and we are passing the user name and password to it.
        // To use the authenticationManager, you need to define a Bean for it, check SecurityConfig.java, it is defined there.
        // Note that verifying the user is a required before generating the token, otherwise, we will be generating tokens for users that we cannot authenticate

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getFirstName(), userDto.getPassword()));
        // If the user is authenticated we generate the token, otherwise, we throw an exception

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userDto.getFirstName());
        } else {
            throw new UsernameNotFoundException("The user cannot be authenticated");
        }
    }

}
