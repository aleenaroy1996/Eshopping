package com.shoppingapp.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("User")
public class UserEntity {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String login;
    private String password;
    private String role;
    private long contactNumber;

}
