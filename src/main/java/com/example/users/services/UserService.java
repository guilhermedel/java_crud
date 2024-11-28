package com.example.users.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import com.example.users.models.User;
import com.example.users.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return repository.findById(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(String id, User user) {
        return repository.findById(id).map(existingUser -> {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return repository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
