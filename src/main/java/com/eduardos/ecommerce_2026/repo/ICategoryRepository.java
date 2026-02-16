package com.eduardos.ecommerce_2026.repo;

import com.eduardos.ecommerce_2026.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends IGenericRepo<Category, Long> {
}
