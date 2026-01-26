package com.eduardos.ecommerce_2026.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @GetMapping("")
    public String testMessage() {
        return "Message from product Controller";
    }
}
