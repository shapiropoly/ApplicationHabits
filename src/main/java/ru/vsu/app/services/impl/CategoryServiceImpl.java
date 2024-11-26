package ru.vsu.app.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Category;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.dto.CategoryDto;
import ru.vsu.app.models.mappers.CategoryMapper;
import ru.vsu.app.repositories.CategoryRepository;
import ru.vsu.app.repositories.HabitRepository;
import ru.vsu.app.services.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private final HabitRepository habitRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    // Добавить категорию
    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = new Category();

        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());

        List<Habit> habitsList = new ArrayList<>();

        if (categoryDto.getHabitsId() != null) {
            for (Integer id : categoryDto.getHabitsId()) {
                Habit habit = habitRepository.findById(id).orElseThrow(() ->
                        new IllegalArgumentException("Привычка не найдена"));
                habitsList.add(habit);
            }
        }

        category.setHabits(habitsList);
        category.setImage(categoryDto.getImage());

        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.toCategoryDto(savedCategory);
    }

    // Обновить категорию
    @Transactional
    @Override
    public CategoryDto updateCategory(Integer id, CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Категория c id: "+ id + " не найдена"));

        existingCategory.setTitle(categoryDto.getTitle());
        existingCategory.setDescription(categoryDto.getDescription());
        existingCategory.setImage(categoryDto.getImage());


        List<Habit> habitsList = new ArrayList<>();
        for (Integer habitId : categoryDto.getHabitsId()) {
            Habit habit = habitRepository.findById(habitId)
                    .orElseThrow(() -> new IllegalArgumentException("Привычка не найдена"));
            habitsList.add(habit);
        }

        existingCategory.setHabits(habitsList);

        Category savedCategory = categoryRepository.save(existingCategory);

        for (Habit habit: savedCategory.getHabits()) {
            habit.setCategory(savedCategory);
        }

        return CategoryMapper.toCategoryDto(savedCategory);
    }

    // удалить категорию
    @Transactional
    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    // найти категорию по id
    @Override
    public CategoryDto getCategoryById(Integer id) {
        Category findCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Категория с id '" + id + "' не найдена"));

        return CategoryMapper.toCategoryDto(findCategory);
    }
}
