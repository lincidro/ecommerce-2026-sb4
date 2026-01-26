package com.eduardos.ecommerce_2026.service.impl;

import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findById() {
        return Optional.empty();
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
