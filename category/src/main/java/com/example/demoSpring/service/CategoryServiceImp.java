package com.example.demoSpring.service;

import com.example.demoSpring.exception.NotFoundException;
import com.example.demoSpring.model.Category;
import com.example.demoSpring.model.CategoryRequest;
import com.example.demoSpring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category by id "+id+ " not found")
        );
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        return categoryRepository.save(categoryRequest.toEntity());
    }

    @Override
    public Category updateCategoryById(Long id, CategoryRequest categoryRequest) {
        getCategoryById(id);
        return categoryRepository.save(categoryRequest.toEntity(id));
    }

    @Override
    public void deleteCategoryById(Long id) {
        getCategoryById(id);
        categoryRepository.deleteById(id);
    }
}
