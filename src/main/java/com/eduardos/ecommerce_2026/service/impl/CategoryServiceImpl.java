package com.eduardos.ecommerce_2026.service.impl;

import com.eduardos.ecommerce_2026.dto.CategoryRequestDTO;
import com.eduardos.ecommerce_2026.dto.CategoryResponseDTO;
import com.eduardos.ecommerce_2026.entity.Category;
import com.eduardos.ecommerce_2026.mapper.ICategoryMapper;
import com.eduardos.ecommerce_2026.repo.CategoryRepository;
import com.eduardos.ecommerce_2026.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private final ICategoryMapper categoryMapper;

    public CategoryServiceImpl(ICategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponseDTO save(CategoryRequestDTO requestDTO) {
        Category category = categoryMapper.DTOtoEntity(requestDTO);
        return categoryMapper.entityToDTO(categoryRepository.save(category));
    }

    @Override
    public void saveAll(List<Category> categories) {
        categoryRepository.saveAll(categories);
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll().stream().map(
                categoryMapper::entityToDTO
        ).toList();
    }

    @Override
    public Page<CategoryResponseDTO> findAll(Pageable pageable) {
        return null;
    }
}
