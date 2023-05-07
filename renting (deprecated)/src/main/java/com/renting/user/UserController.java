package com.renting.user;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserController {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "Sergei", "Eensalu", 55555555, "sergei@gmail.com"),
            new User(2, "Armin", "Remenyi", 66666666, "armin@gmail.com"),
            new User(3, "Taimour", "Khan", 7777777, "taimour@gmail.com")
    ));

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer userId) {
        return users.stream().filter(c -> c.getUserId().equals(userId)).findFirst().get();
    }

    @PostMapping("/user")
    public void addUser(@PathVariable User user) {
        users.add(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody User userToUpdate, @PathVariable Integer userId) {
        for (int i = 0; i < users.size(); i++) {
            User c = users.get(i);
            if (c.getUserId().equals(userId)) {
                users.set(i, userToUpdate);
                return;
            }
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer userId) {
        users.removeIf(c -> c.getUserId().equals(userId));
    }

}
