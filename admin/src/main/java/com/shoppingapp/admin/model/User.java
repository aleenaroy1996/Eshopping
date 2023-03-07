package com.shoppingapp.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String login;
    private String password;
    private String role;
    private long contactNumber;

}
