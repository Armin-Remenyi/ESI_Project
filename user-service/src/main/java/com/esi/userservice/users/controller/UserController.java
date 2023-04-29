package com.esi.userservice.users.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esi.userservice.users.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "Sergei", "Eensalu", 55555555, "sergei@gmail.com", LocalDate.of(2017, 1, 13)),
            new User(2, "Armin", "Remenyi", 66666666, "armin@gmail.com", LocalDate.of(2022, 1, 13)),
            new User(3, "Taimour", "Khan", 7777777, "taimour@gmail.com", LocalDate.of(2023, 12, 1))
    ));

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer userId) {
        return users.stream().filter(c -> c.getUserId().equals(userId)).findFirst().get();
    }

    @PostMapping("/users")
    public void addUser(@PathVariable User user) {
        users.add(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User userToUpdate, @PathVariable Integer userId) {
        for (int i = 0; i < users.size(); i++) {
            User c = users.get(i);
            if (c.getUserId().equals(userId)) {
                users.set(i, userToUpdate);
                return;
            }
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer userId) {
        users.removeIf(c -> c.getUserId().equals(userId));
    }

}
