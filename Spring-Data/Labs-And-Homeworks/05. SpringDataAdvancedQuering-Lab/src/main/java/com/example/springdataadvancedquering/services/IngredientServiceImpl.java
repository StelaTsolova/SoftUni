package com.example.springdataadvancedquering.services;

import com.example.springdataadvancedquering.entities.Ingredient;
import com.example.springdataadvancedquering.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> getAllNamesStartingWith(String letters) {
        return this.ingredientRepository.getAllByNameStartingWith(letters)
                .stream().map(Ingredient::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllNamesWhichInGivenCollectionOrderByPrice(List<String> names) {
        return this.ingredientRepository.getAllByNameInOrderByPrice(names)
                .stream().map(Ingredient::getName).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteIngredientByGivenName(String name) {
        this.ingredientRepository.deleteByGivenName(name);
    }

    @Override
    @Transactional
    public void increasesPriceBy10Percent() {
        this.ingredientRepository.increasesPriceBy10Percent();
    }

    @Override
    @Transactional
    public void increasesPriceByPercentByNamesInCollection(int percent, Collection<String> names) {
        this.ingredientRepository.increasesPriceByGivenPercentByNamesInGivenCollection(percent, names);
    }
}
