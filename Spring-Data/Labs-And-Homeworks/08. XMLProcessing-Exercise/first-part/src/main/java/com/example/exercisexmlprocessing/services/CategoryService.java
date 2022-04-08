package com.example.exercisexmlprocessing.services;

import com.example.exercisexmlprocessing.models.dtos.categoriesByProductsCount.CategoryProductsCountRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.CategorySeedDto;
import com.example.exercisexmlprocessing.models.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    long getEntityCount();

    void seedCategories(List<CategorySeedDto> categories);

    Set<Category> findRandomCategories();

    CategoryProductsCountRootDto getCategoryProductsCountRootDto();
}
