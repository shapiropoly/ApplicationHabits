package ru.vsu.app.models.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Integer id;
    private String title;
    private String description;
    private List<Integer> habitsId;
    private String image;

    public CategoryDto() {
    }

    public CategoryDto(String title, String description, List<Integer> habitsId, String image) {
        this.title = title;
        this.description = description;
        this.habitsId = habitsId;
        this.image = image;
    }
}
