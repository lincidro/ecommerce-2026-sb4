package com.eduardos.ecommerce_2026.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CategoryRequestDTO(
    @NotBlank String name,
    @Positive String description
) {}
