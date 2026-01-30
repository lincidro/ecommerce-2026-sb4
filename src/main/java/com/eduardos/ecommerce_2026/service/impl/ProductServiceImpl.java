package com.eduardos.ecommerce_2026.service.impl;

import com.eduardos.ecommerce_2026.dto.ProductRequestDTO;
import com.eduardos.ecommerce_2026.dto.ProductResponseDTO;
import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.entity.ProductDetail;
import com.eduardos.ecommerce_2026.mapper.IProductMapper;
import com.eduardos.ecommerce_2026.repo.ProductDetailRepository;
import com.eduardos.ecommerce_2026.repo.ProductRepository;
import com.eduardos.ecommerce_2026.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository prodRepo;

    @Autowired
    ProductDetailRepository productDetailRepo;

    private final IProductMapper productMapper;

    public ProductServiceImpl(IProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDTO save(ProductRequestDTO requestDTO) {
        Product product = productMapper.DTOtoEntity(requestDTO);

        if (requestDTO.detail() != null) {
            ProductDetail detail = productMapper.DTOtoEntity(requestDTO.detail());

            // 🔴 THESE TWO LINES ARE MANDATORY
            detail.setProduct(product);   // owning side (FK)
            product.setDetail(detail);    // inverse side
        }

        return productMapper.entityToDTO(prodRepo.save(product));
    }

    @Override
    public void saveAll(List<Product> products) {
        prodRepo.saveAll(products);
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        return prodRepo.findAll().stream().map(
                productMapper::entityToDTO
        ).toList();
    }

    @Override
    public List<ProductResponseDTO> findAllEntityQuery() {
        return List.of();
    }

    @Override
    public List<ProductResponseDTO> findAllEntityGraph() {
        return prodRepo.findAll().stream().map(
                productMapper::entityToDTO
        ).toList();
    }

    @Override
    public Optional<ProductResponseDTO> findById(Long id) {
        Optional<Product> product = prodRepo.findById(id);
        return Optional.ofNullable(product
                .map(productMapper::entityToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Product not found")));
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        // Find product with detail
        Optional<Product> optionalProduct = prodRepo.findById(id);

        Product product = optionalProduct.orElseThrow(
                () -> new EntityNotFoundException("Product not found with ID: " + id)
        );

        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
        product.setStatus(dto.status());

        if (dto.detail() != null) {
            ProductDetail detail = product.getDetail();
            // Validate if detail is empty
            if (detail == null) {
                detail = productMapper.DTOtoEntity(dto.detail());
                // 2 mandatory sets
                detail.setProduct(product);
                product.setDetail(detail);
            }
            // If detail exists → update it
            else {
                detail.setDescription(dto.detail().description());
                detail.setWeight(dto.detail().weight());
                detail.setDimensions(dto.detail().dimensions());
            }
        }

        return productMapper.entityToDTO(prodRepo.save(product));
    }

    @Override
    public void delete(Long id) {
        // I think this is never used IRL
        Optional<Product> optionalProduct = prodRepo.findById(id);
        Product product = optionalProduct.orElseThrow(
                () -> new EntityNotFoundException("Product not found with ID: " + id)
        );
        prodRepo.delete(product);
    }
}
