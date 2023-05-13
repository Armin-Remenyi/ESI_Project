package com.esi.userservice.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.userservice.users.dto.UserDto;
import com.esi.userservice.users.model.User;
import com.esi.userservice.users.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final KafkaTemplate<String, UserDto> kafkaTemplate; //class provided by the Spring Kafka library that is used to send messages to Kafka topics

    public List<UserDto> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users.stream().map(this::mapToUserDto).toList();
    }

    private UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .created(user.getCreated())
                .build();
    }

    public Optional<UserDto> getUser(UUID userid) {
        Optional<User> user = userRepository.findById(userid);
        return user.map(this::mapToUserDto);
    }

    public Optional<UserDto> getUserByFirstName(String firstName) {
        Optional<User> user = userRepository.findByFirstName(firstName);
        return user.map(this::mapToUserDto);
    }

    public User addUser(UserDto userDto) {
        log.info("AAAAAAAAAAAAAAAAAAAAAAAAA {}", userDto.getUserId());

        User user = User.builder()
                .userId(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phoneNumber(userDto.getPhoneNumber())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .created(userDto.getCreated())
                .build();

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        kafkaTemplate.send("UserDataTopic", userDto);
        log.info("User {} is added to the Database", user.getUserId());

        return user;
    }


    public void updateUser(UserDto userDto, UUID userId) {
        User user = User.builder()
                .userId(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phoneNumber(userDto.getPhoneNumber())
                .email(userDto.getEmail())
                .created(userDto.getCreated())
                .build();
        userRepository.save(user);
        log.info("User {} is updated", user.getUserId());
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
        log.info("A User has been deleted");
    }
};
