package com.example.exercisexmlprocessing.services.impls;

import com.example.exercisexmlprocessing.models.dtos.productsInRange.ProductInRangeDto;
import com.example.exercisexmlprocessing.models.dtos.productsInRange.ProductInRangeRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.ProductSeedDto;
import com.example.exercisexmlprocessing.models.entities.Product;
import com.example.exercisexmlprocessing.models.entities.User;
import com.example.exercisexmlprocessing.repositories.ProductRepository;
import com.example.exercisexmlprocessing.services.CategoryService;
import com.example.exercisexmlprocessing.services.ProductService;
import com.example.exercisexmlprocessing.services.UserService;
import com.example.exercisexmlprocessing.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ValidationUtil validator, ModelMapper modelMapper,
                              ProductRepository productRepository, UserService userService,
                              CategoryService categoryService) {
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public long getEntityCount() {
        return this.productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products.stream().filter(this.validator::isValid)
                .map(this::getProduct)
                .forEach(this.productRepository::save);
    }

    private Product getProduct(ProductSeedDto productSeedDto) {
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
    }

    @Override
    public ProductInRangeRootDto getProductInRangeRootDto() {
        ProductInRangeRootDto rootDto = new ProductInRangeRootDto();

        rootDto.setProducts(this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500L),
                        BigDecimal.valueOf(1000L))
                .stream().map(product -> {
                    ProductInRangeDto dto = this.modelMapper.map(product, ProductInRangeDto.class);
                    dto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName() == null ? ""
                            : product.getSeller().getFirstName() ,
                            product.getSeller().getLastName()));

                    return dto;
                })
                .collect(Collectors.toList()));

        return rootDto;
    }
}
