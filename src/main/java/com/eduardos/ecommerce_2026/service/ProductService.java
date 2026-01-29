package com.eduardos.ecommerce_2026.service;

import com.eduardos.ecommerce_2026.dto.ProductRequestDTO;
import com.eduardos.ecommerce_2026.dto.ProductResponseDTO;
import com.eduardos.ecommerce_2026.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductResponseDTO save(ProductRequestDTO requestDTO);
    void saveAll(List<Product> product);
    List<ProductResponseDTO> findAll();
    List<ProductResponseDTO> findAllEntityQuery();
    List<ProductResponseDTO> findAllEntityGraph();
    Optional<ProductResponseDTO> findById(Long id);
    ProductResponseDTO update(Long id, ProductRequestDTO requestDTO);
    void delete(Long id);
}
