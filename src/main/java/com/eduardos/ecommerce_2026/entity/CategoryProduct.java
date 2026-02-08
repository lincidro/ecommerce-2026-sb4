package com.eduardos.ecommerce_2026.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category_products")
public class CategoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔑 Many OrderItems belong to one Order
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // 🔑 Many OrderItems refer to one Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
