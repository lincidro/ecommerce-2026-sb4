package com.eduardos.ecommerce_2026.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
//    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductDetail detail;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

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
