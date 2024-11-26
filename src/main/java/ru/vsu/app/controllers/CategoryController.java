package ru.vsu.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.Category;
import ru.vsu.app.models.dto.CategoryDto;
import ru.vsu.app.models.dto.HabitDto;
import ru.vsu.app.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // получить список категорий
    @GetMapping
    public List<CategoryDto> listCategories() {
        return categoryService.getAllCategories();
    }

    // добавить категорию
    @PostMapping("add_category")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }


    // изменить категорию
    @PutMapping("update_category/{id}")
    public CategoryDto updateCategory(@PathVariable Integer id,
                                      @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(id, categoryDto);
    }

    // удалить категорию
    @DeleteMapping("delete_category/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

    // получить категорию по id
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }
}
