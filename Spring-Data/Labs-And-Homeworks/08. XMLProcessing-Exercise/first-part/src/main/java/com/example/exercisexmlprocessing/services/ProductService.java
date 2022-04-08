package com.example.exercisexmlprocessing.services;

import com.example.exercisexmlprocessing.models.dtos.productsInRange.ProductInRangeRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.ProductSeedDto;

import java.util.List;

public interface ProductService {

    long getEntityCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductInRangeRootDto getProductInRangeRootDto();
}
