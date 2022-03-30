package com.example.springdataadvancedquering.repositories;

import com.example.springdataadvancedquering.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> getAllByNameStartingWith(String letters);

    List<Ingredient> getAllByNameInOrderByPrice(Collection<String> names);

    @Query("DELETE FROM Ingredient i WHERE i.name = :name")
    @Modifying
    void deleteByGivenName(String name);

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1")
    @Modifying
    void increasesPriceBy10Percent();

    @Query("UPDATE Ingredient i SET i.price = i.price * (1 + (:percent / 100)) WHERE i.name IN :names")
    @Modifying
    void increasesPriceByGivenPercentByNamesInGivenCollection(int percent, Collection<String> names);
}
