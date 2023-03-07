package com.shoppingapp.admin.controller;

import com.shoppingapp.admin.model.User;
import com.shoppingapp.admin.repository.UserRepo;
import com.shoppingapp.admin.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "admin-service")
@Slf4j
@RestController
@RequestMapping("/api/v1.0/shopping")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully!!", HttpStatus.CREATED);
        }catch(Exception e) {
            log.info("inside exception block"+e.toString());
            if(e.getMessage().contains("User already exists!!")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{userName}/forgot")
    public ResponseEntity<String> forgotPassword(@PathVariable String userName) {
        try {
            String result = userService.forgotPassword(userName);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch(Exception e) {
            log.info("inside exception block"+e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
