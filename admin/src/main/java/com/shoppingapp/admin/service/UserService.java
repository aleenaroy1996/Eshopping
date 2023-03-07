package com.shoppingapp.admin.service;

import com.shoppingapp.admin.entity.UserEntity;
import com.shoppingapp.admin.model.EnumRole;
import com.shoppingapp.admin.model.User;
import com.shoppingapp.admin.repository.UserRepo;
import com.shoppingapp.admin.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PasswordUtil passwordUtil;
    private final NextSequenceService nextSequenceService;

    public User registerUser(@RequestBody User user) throws Exception {
        if(userRepo.existsByEmail(user.getEmail())){
            throw new Exception("User already exits!!");
        }
        user.setRole(String.valueOf(EnumRole.CUSTOMER));
        try {
            ModelMapper modelMapper = new ModelMapper();
            UserEntity userEntity = modelMapper.map(user, UserEntity.class);
            userEntity.setId(nextSequenceService.getNextSequence("userId"));
            userEntity.setPassword(passwordUtil.encrypt(user.getPassword()));
            userRepo.save(userEntity);
            return user;
        }catch(Exception e) {
            throw e;
        }
    }

    public String forgotPassword(String userName) throws Exception {
        try {
            Optional<UserEntity> userEntityOptional= userRepo.findByUserName(userName);
            if(null!=userEntityOptional.get()){
                String ecryptedPassword = userEntityOptional.get().getPassword();
                return "Your password is: "+ passwordUtil.decrypt(ecryptedPassword);
            }
            else{
                return "User not found!!";
            }

        }catch(Exception e) {
            throw e;
        }
    }

}
