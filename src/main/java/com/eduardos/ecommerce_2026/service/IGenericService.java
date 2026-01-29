package com.eduardos.ecommerce_2026.service;

import com.eduardos.ecommerce_2026.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T> {
    Product save(T t);
    void saveAll(List<T> T);
    List<T> findAll();
    Optional<T> findById(Long id);
//    Product update(Long id, ProductDTO productDTO);
    void delete(Long id);
}
