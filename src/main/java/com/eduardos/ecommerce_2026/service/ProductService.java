package com.eduardos.ecommerce_2026.service;

import com.eduardos.ecommerce_2026.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById();
    Product update(Product product);
    void delete(Long id);
}
