package com.eduardos.ecommerce_2026.service;

import com.eduardos.ecommerce_2026.dto.CategoryRequestDTO;
import com.eduardos.ecommerce_2026.dto.CategoryResponseDTO;
import com.eduardos.ecommerce_2026.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService{

    CategoryResponseDTO save(CategoryRequestDTO requestDTO);
    void saveAll(List<Category> categories);
    List<CategoryResponseDTO> findAll();
    Page<CategoryResponseDTO> findAll(Pageable pageable);
}
