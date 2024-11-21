package ru.vsu.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.Category;
import ru.vsu.app.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    // получить список категорий
    @GetMapping
    public List<Category> listCategories() {
        return categoryService.getAllCategories();
    }

    // добавить категорию
    @PostMapping("add_category")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    // изменить категорию
    @PutMapping("update_category")
    public Category updateCategory(Category category) {
        return categoryService.updateCategory(category);
    }

    // удалить категорию
    @DeleteMapping("delete_category/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

    // получить категорию по id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // получить категорию по title
    @GetMapping("/{title}")
    public Category getCategoryByTitle(@PathVariable String title) {
        return categoryService.getCategoryByTitle(title);
    }
}
