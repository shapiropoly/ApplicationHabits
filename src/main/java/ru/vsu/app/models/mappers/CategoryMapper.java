package ru.vsu.app.models.mappers;

import ru.vsu.app.models.Category;
import ru.vsu.app.models.dto.CategoryDto;


public class CategoryMapper {
    public static CategoryDto toCategoryDto(Category category) {
        CategoryDto dto = new CategoryDto();

        dto.setId(category.getId());
        dto.setTitle(category.getTitle());
        dto.setDescription(category.getDescription());
        dto.setImage(category.getImage());
        return dto;
    }
}
