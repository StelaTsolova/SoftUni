package com.example.springdataadvancedquering.services;

import java.util.Collection;
import java.util.List;

public interface IngredientService {

    List<String> getAllNamesStartingWith(String letters);

    List<String> getAllNamesWhichInGivenCollectionOrderByPrice(List<String> names);

    void deleteIngredientByGivenName(String name);

    void increasesPriceBy10Percent();

    void increasesPriceByPercentByNamesInCollection(int percent, Collection<String> names);
}
