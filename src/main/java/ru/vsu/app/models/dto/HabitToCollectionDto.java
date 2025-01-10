package ru.vsu.app.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitToCollectionDto {
    @JsonProperty("habit_id")
    private int habitId;
    @JsonProperty("collection_id")
    private int collectionId;

    public HabitToCollectionDto() {
    }

    public HabitToCollectionDto(int habitId, int collectionId) {
        this.habitId = habitId;
        this.collectionId = collectionId;
    }
}
