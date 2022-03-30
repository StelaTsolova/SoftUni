package com.example.springdataadvancedquering.repositories;

import com.example.springdataadvancedquering.entities.Shampoo;
import com.example.springdataadvancedquering.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    Set<Shampoo> getAllBySizeOrderById(Size size);

    Set<Shampoo> getAllBySizeOrLabel_IdOrderByPrice(Size size, Long labelId);

    Set<Shampoo> getAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE  i.name IN :names")
    Set<Shampoo> getAllWhereIngredientInGivenCollection(Collection<String> names);

    @Query("SELECT s FROM Shampoo s where s.ingredients.size < :number")
    Set<Shampoo> getAllWhereIngredientsLessThanGivenNumber (int number);
}
