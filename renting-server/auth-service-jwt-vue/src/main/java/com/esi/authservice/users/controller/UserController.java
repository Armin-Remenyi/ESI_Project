package com.esi.authservice.users.controller;

import com.esi.authservice.config.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.esi.authservice.jwt.JwtService;
import com.esi.authservice.users.dto.UserDto;
import com.esi.authservice.users.model.User;
import com.esi.authservice.users.service.UserService;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@CrossOrigin(origins = {"http://localhost:9090/",  "http://localhost:8080/"})
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/login")
    public String logInAndGetToken(@RequestBody UserDto userDto) {

        if (userDto.getName() == null || userDto.getPassword() == null) {
            throw new UsernameNotFoundException("UserName or Password is Empty");
        }


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getName(), userDto.getPassword()));
        // If the user is authenticated we generate the token, otherwise, we throw an exception
        //log.info("authentication.isAuthenticated()  {} ", authentication);

        if (authentication.isAuthenticated()) {
            log.info("jwtService.generateToken(authRequest.getName())  {} ", jwtService.generateToken(userDto.getName()).toString());
            return jwtService.generateToken(userDto.getName());
        } else {
            throw new UsernameNotFoundException("The user cannot be authinticated!");
        }
    }

    @GetMapping("/authenticate")
    public Boolean authenticate(@RequestHeader("Authorization") String header) {
        String token = header.replace("Bearer ", "");
        log.info(" authenticate - token {} ", token);
        return jwtService.validateToken(token);
    }

    @PostMapping("/signup")
    public String signupUser(@RequestBody User user) {
        userService.addUser(user);
        String jwtToken = jwtService.generateToken(user.getName());
        return jwtToken;
    }

    @GetMapping("/public")
    public String publicAPI() {
        log.info("This is an unprotected endpoint");
        return "This is an unprotected endpoint";
    }

    @GetMapping("/user/{userName}")
    public UserDetails loadUserByUserName(@PathVariable String userName) {
        return userDetailsService.loadUserByUsername(userName);
    }

    @DeleteMapping("/user/{id}")
    public void loadUserByUserName(@PathVariable UUID id) {
        userDetailsService.deleteUserById(id);
    }

    @GetMapping("/admin")
    public String adminAPI() {
        log.info("Protected endpoint - only admins are allowed");
        return "Protected endpoint - only admins are allowed";
    }

}
