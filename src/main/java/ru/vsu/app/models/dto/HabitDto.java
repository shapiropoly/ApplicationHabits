package ru.vsu.app.models.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class HabitDto {
    private Integer id;
    private String title;
    private String description;
    private Integer categoryId;
    private String image;

    public HabitDto() {
    }

    public HabitDto(String title, String description,
                    Integer categoryId, String image) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.image = image;
    }
}




