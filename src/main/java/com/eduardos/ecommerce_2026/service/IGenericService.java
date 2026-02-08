package com.eduardos.ecommerce_2026.service;

import com.eduardos.ecommerce_2026.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T, ID> {
    T save(T t);
    void saveAll(List<T> T);
    List<T> findAll();
    Optional<T> findById(ID id);
    T update(ID id, T t);
    void delete(ID id);
}
