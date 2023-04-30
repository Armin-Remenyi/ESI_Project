package com.esi.userservice.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esi.userservice.users.dto.UserDto;
import com.esi.userservice.users.model.User;
import com.esi.userservice.users.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // private List<User> users = new ArrayList<>(Arrays.asList(
    //         new User(1, "Sergei", "Eensalu", 55555555, "sergei@gmail.com", LocalDate.of(2017, 1, 13)),
    //         new User(2, "Armin", "Remenyi", 66666666, "armin@gmail.com", LocalDate.of(2022, 1, 13)),
    //         new User(3, "Taimour", "Khan", 7777777, "taimour@gmail.com", LocalDate.of(2023, 12, 1))
    // ));

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public Optional <UserDto> getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public void addUser(@PathVariable UserDto userDto) {
        userService.addUser(userDto);
    }

    @PutMapping("/users/{userId}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
       userService.updateUser(userDto, userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }

}
