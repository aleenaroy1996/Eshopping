package com.shoppingapp.admin.service;

import java.util.ArrayList;
import java.util.Optional;

import com.shoppingapp.admin.entity.UserEntity;
import com.shoppingapp.admin.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = userRepo.findByUserName(username);
        if (userEntityOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        UserEntity user = userEntityOptional.get();
        return new User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
    }
}