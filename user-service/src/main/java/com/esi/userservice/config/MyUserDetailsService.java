package com.esi.userservice.config;

import java.util.Optional;

import com.esi.userservice.users.model.User;
import com.esi.userservice.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByFirstName(username);
        user
                .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
        return user.map(MyUserDetails::new).get();
    }
}