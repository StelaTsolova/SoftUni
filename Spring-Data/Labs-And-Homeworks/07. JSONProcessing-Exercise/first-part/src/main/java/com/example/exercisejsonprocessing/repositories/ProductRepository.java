package com.example.exercisejsonprocessing.repositories;

import com.example.exercisejsonprocessing.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerNullOrderByPrice(BigDecimal lower, BigDecimal upper);
}
