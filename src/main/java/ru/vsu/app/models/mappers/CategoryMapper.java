package ru.vsu.app.models.mappers;

import ru.vsu.app.models.Category;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static CategoryDto toCategoryDto(Category category) {
        CategoryDto dto = new CategoryDto();

        dto.setId(category.getId());
        dto.setTitle(category.getTitle());
        dto.setDescription(category.getDescription());

        List<Integer> habitsId = new ArrayList<>();

        if (category.getHabits() != null) {
            habitsId.addAll(category.getHabits().stream()
                    .map(Habit::getId)
                    .toList());
        }

        dto.setHabitsId(habitsId);

        dto.setImage(category.getImage());
        return dto;
    }
}
