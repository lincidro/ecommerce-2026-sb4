package com.eduardos.ecommerce_2026.mapper;

import com.eduardos.ecommerce_2026.dto.ProductDetailRequestDTO;
import com.eduardos.ecommerce_2026.dto.ProductDetailResponseDTO;
import com.eduardos.ecommerce_2026.dto.ProductRequestDTO;
import com.eduardos.ecommerce_2026.dto.ProductResponseDTO;
import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.entity.ProductDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    Product DTOtoEntity(ProductRequestDTO dto);
    ProductResponseDTO entityToDTO(Product entity);
    ProductDetail DTOtoEntity(ProductDetailRequestDTO dto);
    ProductDetailResponseDTO entityToDTO(ProductDetail entity);
}
