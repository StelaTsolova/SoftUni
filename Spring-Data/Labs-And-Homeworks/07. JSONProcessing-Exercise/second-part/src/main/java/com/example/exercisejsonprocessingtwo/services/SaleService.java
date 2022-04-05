package com.example.exercisejsonprocessingtwo.services;

import com.example.exercisejsonprocessingtwo.models.dtos.SaleDiscountDto;

import java.util.Set;

public interface SaleService {

    void seedSales();

    Set<SaleDiscountDto> getSaleDiscountDtos();
}
