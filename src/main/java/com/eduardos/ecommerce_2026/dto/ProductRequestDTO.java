package com.eduardos.ecommerce_2026.dto;

import com.eduardos.ecommerce_2026.entity.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductRequestDTO (
    @NotBlank String name,
    @Positive BigDecimal price,
    @PositiveOrZero int stock,
    ProductStatus status,
    ProductDetailRequestDTO detail // Should be the same name of class if it's e.g. prod_detail it won't work with mapstrcut
) {}
