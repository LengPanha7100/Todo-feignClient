package com.example.demoSpring.service;


import com.example.demoSpring.model.Category;
import com.example.demoSpring.model.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category getCategoryById(Long id);

    Category createCategory(CategoryRequest categoryRequest);

    Category updateCategoryById(Long id, CategoryRequest categoryRequest);

    void deleteCategoryById(Long id);
}
