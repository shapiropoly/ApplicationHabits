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
    private String image;

    public CategoryDto() {
    }

    public CategoryDto(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
