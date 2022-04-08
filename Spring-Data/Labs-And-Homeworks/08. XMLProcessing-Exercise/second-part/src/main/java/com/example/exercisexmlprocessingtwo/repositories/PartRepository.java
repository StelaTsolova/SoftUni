package com.example.exercisexmlprocessingtwo.repositories;

import com.example.exercisexmlprocessingtwo.models.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
