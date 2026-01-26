package com.eduardos.ecommerce_2026.service;

import com.eduardos.ecommerce_2026.dto.ProductDTO;
import com.eduardos.ecommerce_2026.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    void saveAll(List<Product> product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product update(Long id, ProductDTO productDTO);
    void delete(Long id);
}
