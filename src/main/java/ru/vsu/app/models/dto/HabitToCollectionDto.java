package ru.vsu.app.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitToCollectionDto {
    private int habitId;
    private int collectionId;

    public HabitToCollectionDto() {
    }

    public HabitToCollectionDto(int habitId, int collectionId) {
        this.habitId = habitId;
        this.collectionId = collectionId;
    }
}
