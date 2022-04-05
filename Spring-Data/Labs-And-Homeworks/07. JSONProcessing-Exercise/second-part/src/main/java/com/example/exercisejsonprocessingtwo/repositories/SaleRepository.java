package com.example.exercisejsonprocessingtwo.repositories;

import com.example.exercisejsonprocessingtwo.models.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
