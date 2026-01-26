package com.eduardos.ecommerce_2026.dto;

import com.eduardos.ecommerce_2026.entity.ProductStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private BigDecimal price;
    private int stock;
    private ProductStatus status;
}
