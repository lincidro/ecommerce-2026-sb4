package com.eduardos.ecommerce_2026.repo;

import com.eduardos.ecommerce_2026.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
