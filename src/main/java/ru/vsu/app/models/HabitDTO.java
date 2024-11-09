package ru.vsu.app.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitDTO {
    private String title;
    private String description;
    private String categoryTitle;
    private String image;

    public HabitDTO() {
    }

    public HabitDTO(String title, String description, String categoryTitle, String image) {
        this.title = title;
        this.description = description;
        this.categoryTitle = categoryTitle;
        this.image = image;
    }
}




