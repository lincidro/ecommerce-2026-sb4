package com.eduardos.ecommerce_2026.controller;

import com.eduardos.ecommerce_2026.dto.CategoryRequestDTO;
import com.eduardos.ecommerce_2026.dto.CategoryResponseDTO;
import com.eduardos.ecommerce_2026.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<CategoryResponseDTO> save(@RequestBody CategoryRequestDTO request) throws Exception {
        // Richardson MM told us to return a location
        CategoryResponseDTO categoryResponseDTO = categoryService.saveDTO(request);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").
                buildAndExpand(categoryResponseDTO.id()).
                toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("list-no-page")
    public ResponseEntity<List<CategoryResponseDTO>> findAll() throws Exception {
        return ResponseEntity.ok(categoryService.findAllDTO());
    }

    @GetMapping("list")
    public ResponseEntity<Page<CategoryResponseDTO>> findAllPageable(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(categoryService.findAllDTOPageable(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<CategoryResponseDTO>> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(categoryService.findByIdDTO(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @RequestBody CategoryRequestDTO requestDTO) throws Exception {
        return ResponseEntity.ok(categoryService.updateDTO(id, requestDTO));
    }

//    @GetMapping("{id}")
//    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id) throws Exception{
//        return categoryService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

//    @PutMapping("{id}")
//    public ResponseEntity<CategoryResponseDTO> updateUser(
//            @PathVariable Long id, @RequestBody ProductRequestDTO request) {
//        return ResponseEntity.ok(categoryService.update(id, request));
//    }
}