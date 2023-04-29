package com.esi.userservice.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.esi.userservice.users.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    
}
