package com.eduardos.ecommerce_2026.service.impl;

import com.eduardos.ecommerce_2026.dto.CategoryRequestDTO;
import com.eduardos.ecommerce_2026.dto.CategoryResponseDTO;
import com.eduardos.ecommerce_2026.entity.Category;
import com.eduardos.ecommerce_2026.exception.ResourceNotFoundException;
import com.eduardos.ecommerce_2026.mapper.ICategoryMapper;
import com.eduardos.ecommerce_2026.mapper.IGenericMapper;
import com.eduardos.ecommerce_2026.repo.ICategoryRepository;
import com.eduardos.ecommerce_2026.repo.IGenericRepo;
import com.eduardos.ecommerce_2026.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryMapper categoryMapper;
    private final ICategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO saveDTO(CategoryRequestDTO categoryRequestDTO) throws Exception {
        Category category = categoryRepository.save(categoryMapper.DTOtoEntity(categoryRequestDTO));
        return categoryMapper.entityToDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> findAllDTO() throws Exception {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    @Override
    public Optional<CategoryResponseDTO> findByIdDTO(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return Optional.ofNullable(categoryMapper.entityToDTO(category));
    }

    @Override
    public CategoryResponseDTO updateDTO(Long id, CategoryRequestDTO categoryRequestDTO) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student not found"));
        categoryMapper.updateFromDto(categoryRequestDTO, category);
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.entityToDTO(updatedCategory);
    }

    @Override
    public Page<CategoryResponseDTO> findAllDTOPageable(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(categoryMapper::entityToDTO);
    }
}
