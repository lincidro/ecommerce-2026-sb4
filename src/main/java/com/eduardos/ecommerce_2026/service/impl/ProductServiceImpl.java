package com.eduardos.ecommerce_2026.service.impl;

import com.eduardos.ecommerce_2026.dto.ProductDTO;
import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.repo.ProductRepository;
import com.eduardos.ecommerce_2026.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void saveAll(List<Product> products) {
        repository.saveAll(products);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> optionalProduct = repository.findById(id);
        Product product = optionalProduct.orElseThrow(
                ()-> new EntityNotFoundException("Product not found with ID: " + id)
        );
        return Optional.ofNullable(product);
    }

    @Override
    public Product update(Long id, ProductDTO dto) {
        Optional<Product> optionalProduct = repository.findById(id);
        Product product = optionalProduct.orElseThrow(
                ()-> new EntityNotFoundException("Product not found with ID: " + id)
        );

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setStatus(dto.getStatus());

        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        // I think this is never used IRL
        Optional<Product> optionalProduct = repository.findById(id);
        Product product = optionalProduct.orElseThrow(
                ()-> new EntityNotFoundException("Product not found with ID: " + id)
        );
        repository.delete(product);
    }
}
