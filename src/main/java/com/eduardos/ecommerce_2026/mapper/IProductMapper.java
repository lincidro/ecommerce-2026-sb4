package com.eduardos.ecommerce_2026.mapper;

import com.eduardos.ecommerce_2026.dto.*;
import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.entity.ProductCategory;
import com.eduardos.ecommerce_2026.entity.ProductDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    Product DTOtoEntity(ProductRequestDTO dto);

    ProductResponseDTO entityToDTO(Product entity);

    ProductDetail DTOtoEntity(ProductDetailRequestDTO dto);

    ProductDetailResponseDTO entityToDTO(ProductDetail entity);


    @Mapping(
            target = "categories",
            expression = "java(mapCategories(product.getCategories()))"
    )
    ProductCategoryResponseDTO prodCatToDTO(Product product);

    default List<CategoryResponseDTO> mapCategories(
            Set<ProductCategory> productCategories
    ) {
        return productCategories.stream()
                .map(pc -> new CategoryResponseDTO(
                        pc.getCategory().getId(),
                        pc.getCategory().getName(),
                        pc.getCategory().getDescription()
                ))
                .toList();
    }
}
