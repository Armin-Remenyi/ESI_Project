package com.esi.userservice.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.userservice.users.model.User;
import com.esi.userservice.users.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<User> getAlLUsers() {
        List<User> properties = new ArrayList<>();
        userRepository.findAll().forEach(properties::add);
        return properties;
    }

    public Optional<User> getUser(Integer userId) {
        return userRepository.findById(userId);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer userId, User user) {
        User existingObject = userRepository.findById(userId).orElse(null);

        if (existingObject != null) {
            existingObject.setFirstName(user.getFirstName());
            existingObject.setLastName(user.getLastName());
            existingObject.setPhoneNumber(user.getPhoneNumber());
            existingObject.setEmail(user.getEmail());

            userRepository.save(existingObject);
        }
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
