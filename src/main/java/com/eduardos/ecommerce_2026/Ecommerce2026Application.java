package com.eduardos.ecommerce_2026;

import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ecommerce2026Application implements CommandLineRunner {

	@Autowired
	ProductService service;

	public static void main(String[] args) {
		SpringApplication.run(Ecommerce2026Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Product> productList = new ArrayList<>();

		// 1. Programmatically set values for each entity
		for (int i = 0; i < 5; i++) {
			Product prod = new Product();
			prod.setName("Producto #" + i);
			prod.setPrice(BigDecimal.valueOf(1.99 + i) );
			// Assuming default values are handled in the entity or DB level
			productList.add(prod);
		}
		service.saveAll(productList);
	}
}
