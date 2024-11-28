package com.example.users.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.users.models.Product;
import com.example.users.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return repository.findById(id);
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        return repository.findById(id).map(existing -> {
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
