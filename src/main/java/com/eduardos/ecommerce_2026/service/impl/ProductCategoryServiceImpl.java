package com.eduardos.ecommerce_2026.service.impl;

import com.eduardos.ecommerce_2026.dto.ProductCategoryResponseDTO;
import com.eduardos.ecommerce_2026.entity.Category;
import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.entity.ProductCategory;
import com.eduardos.ecommerce_2026.mapper.IProductMapper;
import com.eduardos.ecommerce_2026.repo.CategoryProductRepository;
import com.eduardos.ecommerce_2026.repo.CategoryRepository;
import com.eduardos.ecommerce_2026.repo.ProductRepository;
import com.eduardos.ecommerce_2026.service.ProductCategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    CategoryProductRepository categoryProductRepository;

    private final IProductMapper productMapper;

    public ProductCategoryServiceImpl(IProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public ProductCategoryResponseDTO save(Long productId, List<Long> categoryIds) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        List<Category> categories =
                categoryRepo.findAllById(categoryIds);

        categories.forEach(product::addCategory);

        return productMapper.prodCatToDTO(
                productRepo.save(product)
        );
    }

    @Override
    public void saveAll(List<ProductCategory> productCategories) {
        categoryProductRepository.saveAll(productCategories);
    }
}