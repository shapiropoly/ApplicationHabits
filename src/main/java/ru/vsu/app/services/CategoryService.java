package ru.vsu.app.services;

import ru.vsu.app.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Integer id);

    Category getCategoryById(Integer id);

    Category getCategoryByTitle(String title);
}