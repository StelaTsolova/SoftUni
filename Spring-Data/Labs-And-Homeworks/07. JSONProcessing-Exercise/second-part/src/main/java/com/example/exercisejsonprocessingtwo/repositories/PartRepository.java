package com.example.exercisejsonprocessingtwo.repositories;

import com.example.exercisejsonprocessingtwo.models.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
