package com.shoppingapp.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Product")
public class ProductEntity {

    @Id
    private int id;
    private String name;
    private String description;
    private String feature;
    private String status;
    private double price;
    private int quantityAvailable;
}
