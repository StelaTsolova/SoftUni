package com.example.exercisexmlprocessingtwo.services;

import com.example.exercisexmlprocessingtwo.models.dtos.salesWithAppliedDiscount.SaleAppliedDiscountRootDto;

public interface SaleService {

    long getEntityCount();

    void seedSales();

    SaleAppliedDiscountRootDto getSaleAppliedDiscountRootDto();
}
