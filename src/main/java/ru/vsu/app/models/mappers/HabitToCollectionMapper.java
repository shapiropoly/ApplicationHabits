package ru.vsu.app.models.mappers;

import ru.vsu.app.models.HabitToCollection;
import ru.vsu.app.models.dto.HabitToCollectionDto;

public class HabitToCollectionMapper {
    public static HabitToCollectionDto toHabitToCollectionDto(
            HabitToCollection habitToCollection) {
        HabitToCollectionDto dto = new HabitToCollectionDto();

        dto.setHabitId(habitToCollection.getHabit().getId());
        dto.setCollectionId(habitToCollection.getCollection().getId());

        return dto;
    }
}
