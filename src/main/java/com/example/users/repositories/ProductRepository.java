package com.example.users.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.users.models.Product;


public interface ProductRepository extends MongoRepository<Product, String> {
}
