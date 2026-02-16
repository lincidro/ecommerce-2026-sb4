package com.eduardos.ecommerce_2026.service;

import com.eduardos.ecommerce_2026.dto.ProductCategoryResponseDTO;
import com.eduardos.ecommerce_2026.entity.ProductCategory;

import java.util.List;

public interface IProductCategoryService {

    ProductCategoryResponseDTO save(Long productId, List<Long> categoryIds);

    // Don't go
    void saveAll(List<ProductCategory> productCategories);
}
