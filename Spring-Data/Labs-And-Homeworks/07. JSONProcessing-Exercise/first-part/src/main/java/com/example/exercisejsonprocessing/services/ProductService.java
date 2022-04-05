package com.example.exercisejsonprocessing.services;

import com.example.exercisejsonprocessing.models.dtos.ProductRangeDto;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    void seedProducts() throws IOException;

    List<ProductRangeDto> findAllProductRangeDtos(double lower, double upper);
}
