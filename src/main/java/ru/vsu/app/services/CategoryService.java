package ru.vsu.app.services;

import ru.vsu.app.models.Category;
import ru.vsu.app.models.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(Integer id, CategoryDto categoryDto);

    void deleteCategory(Integer id);

    CategoryDto getCategoryById(Integer id);
}