package com.example.exercisexmlprocessingtwo.repositories;

import com.example.exercisexmlprocessingtwo.models.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
