package com.shoppingapp.product.repository;

import com.shoppingapp.product.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepo extends MongoRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findByName(String name);
}
