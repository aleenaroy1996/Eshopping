package com.shoppingapp.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String name;
    private String description;
    private String feature;
    private String status;
    private double price;
    private int quantityAvailable;
}
