package com.example.springdataadvancedquering.services;

import com.example.springdataadvancedquering.entities.Shampoo;
import com.example.springdataadvancedquering.entities.Size;
import com.example.springdataadvancedquering.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService{

    private ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public Set<Shampoo> getAllBySizeOrderById(Size size) {
        return this.shampooRepository.getAllBySizeOrderById(size);
    }

    @Override
    public Set<Shampoo> getAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId) {
        return this.shampooRepository.getAllBySizeOrLabel_IdOrderByPrice(size, labelId);
    }

    @Override
    public Set<Shampoo> getAllByPriceGreaterThanGivenPriceOrderByPriceDesc(BigDecimal price) {
        return this.shampooRepository.getAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int getCountShampoosWithPriceLowerThanGivenPrice(BigDecimal price) {
        return this.shampooRepository.countAllByPriceLessThan(price);
    }

    @Override
    public Set<String> getBrandsWhereIngredientInGivenCollection(Collection<String> names) {
        return this.shampooRepository.getAllWhereIngredientInGivenCollection(names)
                .stream().map(Shampoo::getBrand).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getBrandsWhereIngredientsLessThanGivenNumber(int number) {
        return this.shampooRepository.getAllWhereIngredientsLessThanGivenNumber(number)
                .stream().map(Shampoo::getBrand).collect(Collectors.toSet());
    }
}
