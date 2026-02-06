package com.eduardos.ecommerce_2026.repo;

import com.eduardos.ecommerce_2026.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("""
//      SELECT p FROM Product p
//      LEFT JOIN FETCH p.detail
//    """)
//    List<Product> findAllWithDetailQuery();

    @EntityGraph(attributePaths = "detail")
    List<Product> findAll();

    @EntityGraph(attributePaths = "detail")
    Page<Product> findAll(Pageable pageable);

    @EntityGraph(attributePaths = "detail")
    Optional<Product> findById(Long id);
}
