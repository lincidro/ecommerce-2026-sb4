package com.eduardos.ecommerce_2026.dto;

import com.eduardos.ecommerce_2026.entity.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record ProductResponseDTO (
        Long id,
        @NotBlank String name,
        @Positive BigDecimal price,
        @PositiveOrZero int stock,
        ProductStatus status,
        ProductDetailResponseDTO detail
) {}