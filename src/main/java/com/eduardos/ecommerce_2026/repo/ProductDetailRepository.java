package com.eduardos.ecommerce_2026.repo;

import com.eduardos.ecommerce_2026.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<Product, Long> {

}
