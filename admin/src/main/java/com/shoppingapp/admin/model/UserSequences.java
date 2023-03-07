package com.shoppingapp.admin.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userSequences")
@Data
public class UserSequences {
    @Id
    private String id;
    private int seq;

}
