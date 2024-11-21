package ru.vsu.app.models;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class HabitDto {
    private Integer id;
    private String title;
    private String description;
    private String image;
    private Integer categoryId;
    private String categoryTitle;

    @ConstructorProperties({"title", "description", "image", "categoryTitle"})
    public HabitDto(String title, String description, String image, String categoryTitle) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.categoryTitle = categoryTitle;
    }

    public HabitDto(Integer id, String title, String description, String image, Integer categoryId, String categoryTitle) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
    }
}




