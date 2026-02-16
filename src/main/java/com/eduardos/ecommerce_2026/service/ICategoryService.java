package com.eduardos.ecommerce_2026.service;

import com.eduardos.ecommerce_2026.dto.CategoryRequestDTO;
import com.eduardos.ecommerce_2026.dto.CategoryResponseDTO;
import com.eduardos.ecommerce_2026.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends IGenericService<
        Category, CategoryRequestDTO, CategoryResponseDTO, Long> {

    Page<CategoryResponseDTO> findAllDTOPageable(Pageable pageable);
}
