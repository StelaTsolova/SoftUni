package com.example.exercisexmlprocessing.services.impls;

import com.example.exercisexmlprocessing.models.dtos.categoriesByProductsCount.CategoryProductsCountDto;
import com.example.exercisexmlprocessing.models.dtos.categoriesByProductsCount.CategoryProductsCountRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.CategorySeedDto;
import com.example.exercisexmlprocessing.models.entities.Category;
import com.example.exercisexmlprocessing.repositories.CategoryRepository;
import com.example.exercisexmlprocessing.services.CategoryService;
import com.example.exercisexmlprocessing.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ValidationUtil validator, ModelMapper modelMapper,
                               CategoryRepository categoryRepository) {
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public long getEntityCount() {
        return this.categoryRepository.count();
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        categories.stream().filter(this.validator::isValid)
                .map(categorySeedDto -> this.modelMapper.map(categorySeedDto, Category.class))
                .forEach(this.categoryRepository::save);
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int countCategories = ThreadLocalRandom.current().nextInt(1, 4);

        for (int i = 0; i < countCategories; i++) {
            categories.add(this.categoryRepository.findById(ThreadLocalRandom.current()
                    .nextLong(1, this.categoryRepository.count() + 1)).orElseThrow());
        }

        return categories;
    }

    @Override
    public CategoryProductsCountRootDto getCategoryProductsCountRootDto() {
        CategoryProductsCountRootDto rootDto = new CategoryProductsCountRootDto();
        rootDto.setCategories(this.categoryRepository.findAllOrderByProductsCount()
                .stream().map(category -> {
                    CategoryProductsCountDto dto = this.modelMapper.map(category, CategoryProductsCountDto.class);
                    dto.setProductCount(category.getProducts().size());
                    dto.setAveragePrice(category.getAverageProductsPriceSum());
                    dto.setTotalRevenue(category.getTotalProductsPriceSum());

                    return dto;
                })
                .collect(Collectors.toList()));

        return rootDto;
    }
}
