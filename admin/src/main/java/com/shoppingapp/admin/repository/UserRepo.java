package com.shoppingapp.admin.repository;

import com.shoppingapp.admin.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface UserRepo extends MongoRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserName(String username);
    boolean existsByEmail(String emailId);
}
