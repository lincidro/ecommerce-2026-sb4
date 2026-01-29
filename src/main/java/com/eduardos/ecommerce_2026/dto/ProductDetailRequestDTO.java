package com.eduardos.ecommerce_2026.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductDetailRequestDTO (
    @NotBlank String description,
    @PositiveOrZero Double weight,
    @NotBlank  String dimensions
){}
