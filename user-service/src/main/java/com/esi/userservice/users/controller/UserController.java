package com.esi.userservice.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esi.userservice.users.dto.UserDto;
import com.esi.userservice.users.service.UserService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public Optional <UserDto> getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody UserDto userDto) {
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
