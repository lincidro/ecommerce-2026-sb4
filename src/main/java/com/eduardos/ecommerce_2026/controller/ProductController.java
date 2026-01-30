package com.eduardos.ecommerce_2026.controller;

import com.eduardos.ecommerce_2026.dto.ProductRequestDTO;
import com.eduardos.ecommerce_2026.dto.ProductResponseDTO;
import com.eduardos.ecommerce_2026.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("")
    public String testMessage() {
        return "Message from product Controller";
    }

    @PostMapping("")
    public ResponseEntity<ProductResponseDTO> save(@RequestBody ProductRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(request));
    }

    @GetMapping("list")
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
//        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponseDTO> updateUser(
            @PathVariable Long id, @RequestBody ProductRequestDTO request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}