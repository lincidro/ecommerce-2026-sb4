package com.eduardos.ecommerce_2026.mapper;

import com.eduardos.ecommerce_2026.dto.*;
import com.eduardos.ecommerce_2026.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    Category DTOtoEntity(CategoryRequestDTO dto);
    CategoryResponseDTO entityToDTO(Category entity);
    List<CategoryResponseDTO> toDtoList(List<Category> categories); // Instead of stream

    // Do NOT create a new object. Update the existing one
    void updateFromDto(CategoryRequestDTO requestDTO, @MappingTarget Category category);
}
