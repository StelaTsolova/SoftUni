package com.example.exercisespringdataintro.services.implementations;

import com.example.exercisespringdataintro.models.entities.Category;
import com.example.exercisespringdataintro.repositories.CategoryRepository;
import com.example.exercisespringdataintro.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.txt";

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH))
                .stream().filter(row -> !row.isBlank()).forEach(this::saveCategory);
    }

    private void saveCategory(String name) {
        Category category = new Category();
        category.setName(name);

        this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getRandomCategories() {
        int countCategory = ThreadLocalRandom.current().nextInt(1, 4);

        Set<Category> categories = new LinkedHashSet<>();
        for (int i = 0; i < countCategory; i++) {
            int id = ThreadLocalRandom.current().nextInt(1,
                    (int) this.categoryRepository.count() + 1);

            categories.add(this.categoryRepository.findById(id).orElseThrow());
        }

        return categories;
    }
}
