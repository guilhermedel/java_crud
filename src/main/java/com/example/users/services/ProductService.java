package com.example.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.users.models.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> getAllProducts() {
        return mongoTemplate.findAll(Product.class);
    }

    public Optional<Product> getProductById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Product.class));
    }

    public Product createProduct(Product product) {
        mongoTemplate.save(product);
        return product;
    }

    public Product updateProduct(String id, Product product) {
        if (mongoTemplate.exists(Query.query(Criteria.where("id").is(id)), Product.class)) {
            product.setId(id);
            mongoTemplate.save(product);
            return product;
        }
        return null;
    }

    public boolean deleteProduct(String id) {
        if (mongoTemplate.exists(Query.query(Criteria.where("id").is(id)), Product.class)) {
            mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), Product.class);
            return true;
        }
        return false;
    }
}
