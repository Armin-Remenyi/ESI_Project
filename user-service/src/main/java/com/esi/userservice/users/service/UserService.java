package com.esi.userservice.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final KafkaTemplate<String, UserDto> kafkaTemplate;

    public List<UserDto> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users.stream().map(this::mapToUserDto).toList();
    }
        private UserDto mapToUserDto(User user){
                return UserDto.builder()
                        .userId(user.getUserid())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .phoneNumber(user.getPhoneNumber())
                        .email(user.getEmail())
                        .created(user.getCreated())
                        .build();
            }
            public Optional<UserDto> getUser(Integer userid){
            Optional<User> user = userRepository.findById(userid);
            return user.map(this::mapToUserDto);
        }

        public void addUser(UserDto userDto) {
            User user = User.builder()
            .userid(userDto.getUserId())
            .firstName(userDto.getFirstName())
            .lastName(userDto.getLastName())
            .phoneNumber(userDto.getPhoneNumber())
            .email(userDto.getEmail())
            .created(userDto.getCreated())
            .build();
            userRepository.save(user);
            kafkaTemplate.send("UserDataTopic", userDto);
        log.info("User {} is added to the Database", user.getUserid());
        }


        public void updateUser(UserDto userDto, Integer userId) {
        User user = User.builder()
            .userid(userDto.getUserId())
            .firstName(userDto.getFirstName())
            .lastName(userDto.getLastName())
            .phoneNumber(userDto.getPhoneNumber())
            .email(userDto.getEmail())
            .created(userDto.getCreated())
            .build();
            userRepository.save(user);
            log.info("User {} is updated", user.getUserid());
        }

        public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
        log.info("A User has been deleted");
        }
};
