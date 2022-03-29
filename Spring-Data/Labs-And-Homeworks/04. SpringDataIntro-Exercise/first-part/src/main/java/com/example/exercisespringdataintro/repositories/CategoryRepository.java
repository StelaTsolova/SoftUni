package com.example.exercisespringdataintro.repositories;

import com.example.exercisespringdataintro.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
