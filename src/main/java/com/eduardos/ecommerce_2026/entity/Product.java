package com.eduardos.ecommerce_2026.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    private BigDecimal price;
    //    Recommended: Using a String for exact precision
    //    BigDecimal price = new BigDecimal("19.99");
    //    Also Safe: Using valueOf (internally converts double to String)
    //    BigDecimal tax = BigDecimal.valueOf(0.07);
    //    Avoid new BigDecimal(0.1); it'll be longer and not precise

    private int stock; // Integer vs int, Integer if empty is blank, int is 0

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private ProductStatus status;


    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("product") // Ignore the 'user' field in the Profile entity during serialization
    private ProductDetail detail;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ProductCategory> categories = new HashSet<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    // ✅ ADD CATEGORY
    public void addCategory(Category category) {
        ProductCategory pc = new ProductCategory();
        pc.setProduct(this);
        pc.setCategory(category);
        categories.add(pc);
    }

    // ✅ REMOVE CATEGORY
    public void removeCategory(Category category) {
        categories.removeIf(pc ->
                pc.getCategory().equals(category)
        );
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = ProductStatus.CREATED;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
