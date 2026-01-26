package com.eduardos.ecommerce_2026.controller;

import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("list")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
