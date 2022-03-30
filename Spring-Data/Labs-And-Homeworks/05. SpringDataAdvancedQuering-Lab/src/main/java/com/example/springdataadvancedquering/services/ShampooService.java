package com.example.springdataadvancedquering.services;

import com.example.springdataadvancedquering.entities.Shampoo;
import com.example.springdataadvancedquering.entities.Size;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

public interface ShampooService {

    Set<Shampoo> getAllBySizeOrderById(Size size);

    Set<Shampoo> getAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId);

    Set<Shampoo> getAllByPriceGreaterThanGivenPriceOrderByPriceDesc(BigDecimal price);

    int getCountShampoosWithPriceLowerThanGivenPrice(BigDecimal price);

    Set<String> getBrandsWhereIngredientInGivenCollection(Collection<String> names);

    Set<String> getBrandsWhereIngredientsLessThanGivenNumber(int number);
}
