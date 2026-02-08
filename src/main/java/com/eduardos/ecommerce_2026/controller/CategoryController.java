package com.eduardos.ecommerce_2026.controller;

import com.eduardos.ecommerce_2026.dto.CategoryRequestDTO;
import com.eduardos.ecommerce_2026.dto.CategoryResponseDTO;
import com.eduardos.ecommerce_2026.dto.ProductRequestDTO;
import com.eduardos.ecommerce_2026.dto.ProductResponseDTO;
import com.eduardos.ecommerce_2026.service.CategoryService;
import com.eduardos.ecommerce_2026.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<CategoryResponseDTO> save(@RequestBody CategoryRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(request));
    }

    @GetMapping("list-no-pageable")
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

//    @GetMapping("list")
//    public ResponseEntity<Page<CategoryResponseDTO>> findAllPageable(@PageableDefault(size = 10, sort = "id")Pageable pageable) {
//        return ResponseEntity.ok(categoryService.findAll(pageable));
//    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id) {
//        return categoryService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
        return null;
    }

//    @PutMapping("{id}")
//    public ResponseEntity<CategoryResponseDTO> updateUser(
//            @PathVariable Long id, @RequestBody ProductRequestDTO request) {
//        return ResponseEntity.ok(categoryService.update(id, request));
//    }
}