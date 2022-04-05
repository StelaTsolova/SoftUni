package com.example.exercisejsonprocessing.repositories;

import com.example.exercisejsonprocessing.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c ORDER BY c.products.size")
    List<Category> findAllOrderByNumberOfProducts();
}
