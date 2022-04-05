package com.example.exercisejsonprocessing;

import com.example.exercisejsonprocessing.models.dtos.ProductRangeDto;
import com.example.exercisejsonprocessing.services.CategoryService;
import com.example.exercisejsonprocessing.services.ProductService;
import com.example.exercisejsonprocessing.services.UserService;
import com.example.exercisejsonprocessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String OUTPUT_PATH = "src/main/resources/output/";
    private static final String PRODUCT_IN_RANGE_NAME = "products-in-range.json";
    private static final String USERS_SOLD_PRODUCT_NAME = "users-sold-products.json";
    private static final String CATEGORIES_BY_PRODUCTS_NAME = "categories-by-products.json";
    private static final String USERS_AND_PRODUCTS_NAME = "users-and-products.json";

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public CommandLineRunnerImpl(UserService userService, CategoryService categoryService,
                                 ProductService productService, Gson gson,
                                 ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
          seedDate();

        // 3.	Query and Export Data
        // productsInRange();

        // successfullySoldProducts();

        // categoriesByProductsCount();

       usersAndProducts();
    }

    private void seedDate() throws IOException {
        this.userService.seedUsers();
        this.categoryService.seedCategories();
        this.productService.seedProducts();
    }

    private void productsInRange() throws IOException {
        List<ProductRangeDto> productRangeDto = this.productService
                .findAllProductRangeDtos(500, 1000);

        String content = this.gson.toJson(productRangeDto);

        writeToFile(OUTPUT_PATH + PRODUCT_IN_RANGE_NAME, content);
    }

    private void successfullySoldProducts() throws IOException {
        String content = this.gson.toJson(this.userService.findAllUserSoldDtos());

        writeToFile(OUTPUT_PATH + USERS_SOLD_PRODUCT_NAME, content);
    }

    private void categoriesByProductsCount() throws IOException {
        String content = this.gson.toJson(this.categoryService.findAllCategoryProductsCountDtos());

        writeToFile(OUTPUT_PATH + CATEGORIES_BY_PRODUCTS_NAME, content);
    }

    private void usersAndProducts() throws IOException {
        String content = this.gson.toJson(this.userService.findAllUserAndProductsDtos());

        writeToFile(OUTPUT_PATH + USERS_AND_PRODUCTS_NAME, content);
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files.write(Path.of(filePath), Collections.singleton(content));
    }
}
