package ru.vsu.app.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Category;
import ru.vsu.app.repositories.CategoryRepository;
import ru.vsu.app.services.CategoryService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = getCategoryByTitle(category.getTitle());

        existingCategory.setTitle(category.getTitle());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setImage(category.getImage());

        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteCategoryById(id);
    }

    @Override
    public Category getCategoryByTitle(String title) {
        return categoryRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Привычка с названием '" + title + "' не найдена"));
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Привычка с id '" + id + "' не найдена"));
    }
}
