package com.eduardos.ecommerce_2026;

import com.eduardos.ecommerce_2026.entity.Category;
import com.eduardos.ecommerce_2026.entity.Product;
import com.eduardos.ecommerce_2026.entity.ProductDetail;
import com.eduardos.ecommerce_2026.service.CategoryService;
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
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(Ecommerce2026Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Category> categoryList = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		List<ProductDetail> productDetailListList = new ArrayList<>();

		// 1. Create test products and its details
		for (int i = 1; i <= 5; i++) {

			// Categories
			Category category = new Category();
			category.setName("Categoría # " + i);
			category.setDescription("Categoría # " + i);
			categoryList.add(category);

			// Products
			Product prod = new Product();
			prod.setName("Producto #" + i);
			prod.setPrice(BigDecimal.valueOf(1.99 + i) );

			// Set Detail
			ProductDetail detail = new ProductDetail();
			detail.setDescription("Descripción de prueba # " + i);
			detail.setWeight(Math.random());
			detail.setDimensions("Dimensiones random para: " + i);
			detail.setProduct(prod);
			prod.setDetail(detail);

			// Assuming default values are handled in the entity or DB level
			productList.add(prod);
		}
		categoryService.saveAll(categoryList);
		productService.saveAll(productList);
	}
}
