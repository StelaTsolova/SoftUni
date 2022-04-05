package com.example.exercisejsonprocessing.services.impl;

import com.example.exercisejsonprocessing.constants.GlobalConstants;
import com.example.exercisejsonprocessing.models.dtos.CategoryProductsCountDto;
import com.example.exercisejsonprocessing.models.dtos.CategorySeedDto;
import com.example.exercisejsonprocessing.models.entities.Category;
import com.example.exercisejsonprocessing.models.entities.Product;
import com.example.exercisejsonprocessing.repositories.CategoryRepository;
import com.example.exercisejsonprocessing.services.CategoryService;
import com.example.exercisejsonprocessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.exercisejsonprocessing.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORY_FILE_NAME = "categories.json";

    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson,
                               ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(this.gson.fromJson(
                            Files.readString(Path.of(RESOURCES_FILE_PATH + CATEGORY_FILE_NAME)),
                            CategorySeedDto[].class))
                    .filter(this.validationUtil::isValid)
                    .map(categorySeedDto -> this.modelMapper.map(categorySeedDto, Category.class))
                    .forEach(this.categoryRepository::save);
        }
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int countCategories = ThreadLocalRandom.current().nextInt(1, 4);

        for (int i = 0; i < countCategories; i++) {
            categories.add(this.categoryRepository.findById(ThreadLocalRandom.current()
                    .nextLong(1, this.categoryRepository.count() + 1)).orElseThrow());
        }

        return categories;
    }

    @Override
    public Set<CategoryProductsCountDto> findAllCategoryProductsCountDtos() {
        this.modelMapper.addMappings(new PropertyMap<Category, CategoryProductsCountDto>() {
            @Override
            protected void configure() {
                map().setCategory(source.getName());
                map().setProductsCount(source.getProductCount());
                map().setAveragePrice(source.getAverageProductsPriceSum());
                map().setTotalRevenue(source.getTotalProductsPriceSum());
            }
        });

        return this.categoryRepository.findAllOrderByNumberOfProducts().stream()
                .map(category -> this.modelMapper.map(category, CategoryProductsCountDto.class))
                .collect(Collectors.toSet());
    }
}
