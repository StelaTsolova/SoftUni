package com.example.exercisejsonprocessing.services.impl;

import com.example.exercisejsonprocessing.models.dtos.ProductRangeDto;
import com.example.exercisejsonprocessing.models.dtos.ProductSeedDto;
import com.example.exercisejsonprocessing.models.entities.Product;
import com.example.exercisejsonprocessing.models.entities.User;
import com.example.exercisejsonprocessing.repositories.ProductRepository;
import com.example.exercisejsonprocessing.services.CategoryService;
import com.example.exercisejsonprocessing.services.ProductService;
import com.example.exercisejsonprocessing.services.UserService;
import com.example.exercisejsonprocessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.exercisejsonprocessing.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT_FILE_NAME = "products.json";

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public ProductServiceImpl(ProductRepository productRepository, UserService userService,
                              CategoryService categoryService, Gson gson,
                              ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedProducts() throws IOException {
        if (this.productRepository.count() == 0) {
            Arrays.stream(this.gson.fromJson(Files.readString(Path.of(RESOURCES_FILE_PATH + PRODUCT_FILE_NAME))
                            , ProductSeedDto[].class)).filter(this.validationUtil::isValid)
                    .map(productSeedDto -> {
                        Product product = this.modelMapper.map(productSeedDto, Product.class);
                        product.setSeller(this.userService.findRandomUser());

                        User user = this.userService.findRandomUser();
                        if (user.getId() == product.getSeller().getId() || user.getId() % 3 == 0) {
                            product.setBuyer(null);
                        } else {
                            product.setBuyer(user);
                        }

                        product.setCategories(this.categoryService.findRandomCategories());

                        return product;
                    }).forEach(this.productRepository::save);
        }
    }

    @Override
    public List<ProductRangeDto> findAllProductRangeDtos(double lower, double upper) {
        Converter<User, String> userNamesToString = new Converter<User, String>() {
            @Override
            public String convert(MappingContext<User, String> mappingContext) {
                return String.format("%s %s", mappingContext.getSource().getFirstName()
                        , mappingContext.getSource().getLastName());
            }
        };
        this.modelMapper.addConverter(userNamesToString);

        return this.productRepository
                .findAllByPriceBetweenAndBuyerNullOrderByPrice(BigDecimal.valueOf(lower), BigDecimal.valueOf(upper))
                .stream().map(product -> this.modelMapper.map(product, ProductRangeDto.class))
                .collect(Collectors.toList());
    }
}
