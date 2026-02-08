package com.eduardos.ecommerce_2026.mapper;

import com.eduardos.ecommerce_2026.dto.*;
import com.eduardos.ecommerce_2026.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    Category DTOtoEntity(CategoryRequestDTO dto);
    CategoryResponseDTO entityToDTO(Category entity);
}
