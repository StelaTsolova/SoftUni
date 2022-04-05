package com.example.exercisejsonprocessing.services;

import com.example.exercisejsonprocessing.models.dtos.CategoryProductsCountDto;
import com.example.exercisejsonprocessing.models.entities.Category;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();

    Set<CategoryProductsCountDto> findAllCategoryProductsCountDtos();
}
