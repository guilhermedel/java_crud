package com.example.users.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.users.models.User;


public interface UserRepository extends MongoRepository<User, String> {
}