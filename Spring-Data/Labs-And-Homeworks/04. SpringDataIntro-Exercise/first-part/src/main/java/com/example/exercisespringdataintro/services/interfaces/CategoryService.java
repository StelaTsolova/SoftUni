package com.example.exercisespringdataintro.services.interfaces;

import com.example.exercisespringdataintro.models.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

   void seedCategories() throws IOException;

   Set<Category> getRandomCategories();
}
