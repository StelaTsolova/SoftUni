package com.example.exercisexmlprocessing;

import com.example.exercisexmlprocessing.models.dtos.usersAndProducts.UserProductsRootDto;
import com.example.exercisexmlprocessing.models.dtos.categoriesByProductsCount.CategoryProductsCountRootDto;
import com.example.exercisexmlprocessing.models.dtos.productsInRange.ProductInRangeRootDto;
import com.example.exercisexmlprocessing.models.dtos.successfullySoldProducts.UserSoldProductsRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.CategorySeedRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.ProductSeedRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.UserSeedRootDto;
import com.example.exercisexmlprocessing.services.CategoryService;
import com.example.exercisexmlprocessing.services.ProductService;
import com.example.exercisexmlprocessing.services.UserService;
import com.example.exercisexmlprocessing.utils.XmlParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private static final String RESOURCES_FILE_NAME = "src/main/resources/";
    private static final String USERS_FILE_NAME = "files/users.xml";
    private static final String CATEGORIES_FILE_NAME = "files/categories.xml";
    private static final String PRODUCTS_FILE_NAME = "files/products.xml";

    private static final String PRODUCTS_IN_RANGE_NAME = "outputs/products-in-range.xml";
    private static final String USERS_SOLD_PRODUCTS_NAME = "outputs/users-sold-products.xml";
    private static final String CATEGORIES_BY_PRODUCTS_NAME = "outputs/categories-by-products.xml";
    private static final String USERS_AND_PRODUCTS_NAME = "outputs/users-and-products.xml";

    private final XmlParser xmlParser;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    public CommandLineRunner(XmlParser xmlParser, UserService userService, CategoryService categoryService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        // 2. Query and Export Data
        // productsInRange();

        // successfullySoldProducts();

        // categoriesByProductsCount();

        usersAndProducts();
    }

    private void seedData() throws JAXBException, IOException {
        if (this.userService.getEntityCount() == 0) {
            UserSeedRootDto userSeedRootDto = this.xmlParser
                    .fromXml(RESOURCES_FILE_NAME + USERS_FILE_NAME, UserSeedRootDto.class);

            this.userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (this.categoryService.getEntityCount() == 0) {
            CategorySeedRootDto categorySeedDto = this.xmlParser
                    .fromXml(RESOURCES_FILE_NAME + CATEGORIES_FILE_NAME, CategorySeedRootDto.class);

            this.categoryService.seedCategories(categorySeedDto.getCategories());
        }

        if (this.productService.getEntityCount() == 0) {
            ProductSeedRootDto productSeedRootDto = this.xmlParser
                    .fromXml(RESOURCES_FILE_NAME + PRODUCTS_FILE_NAME, ProductSeedRootDto.class);

            this.productService.seedProducts(productSeedRootDto.getProducts());
        }
    }

    private void productsInRange() throws JAXBException, IOException {
        ProductInRangeRootDto productInRangeRootDto = this.productService.getProductInRangeRootDto();

        this.xmlParser.toXml(RESOURCES_FILE_NAME + PRODUCTS_IN_RANGE_NAME, productInRangeRootDto);
    }

    private void successfullySoldProducts() throws JAXBException, IOException {
        UserSoldProductsRootDto userSoldProductsRootDto = this.userService.getUserSoldProductsRootDto();

        this.xmlParser.toXml(RESOURCES_FILE_NAME + USERS_SOLD_PRODUCTS_NAME, userSoldProductsRootDto);
    }

    private void categoriesByProductsCount() throws JAXBException, IOException {
        CategoryProductsCountRootDto categoryProductsCountRootDto = this.categoryService.getCategoryProductsCountRootDto();

        this.xmlParser.toXml(RESOURCES_FILE_NAME + CATEGORIES_BY_PRODUCTS_NAME, categoryProductsCountRootDto);
    }

    private void usersAndProducts() throws JAXBException, IOException {
        UserProductsRootDto userProductsRootDto = this.userService.getUserProductsRootDto();

        this.xmlParser.toXml(RESOURCES_FILE_NAME + USERS_AND_PRODUCTS_NAME, userProductsRootDto);
    }
}
