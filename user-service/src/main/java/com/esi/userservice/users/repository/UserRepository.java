package com.esi.userservice.users.repository;

import org.springframework.data.repository.CrudRepository;
import com.esi.userservice.users.model.User;

import java.util.UUID;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByFirstName(String username);
}
