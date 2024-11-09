package ru.vsu.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Category;
import ru.vsu.app.models.Habit;
import ru.vsu.app.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public void add(Category category) {
        categoryRepository.save(category);
    }

    public Category findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public void findByTitle2(String title) {
        System.out.println(categoryRepository.findByTitle(title));
    }
}
