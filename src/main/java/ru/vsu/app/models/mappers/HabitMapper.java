package ru.vsu.app.models.mappers;

import ru.vsu.app.models.Habit;
import ru.vsu.app.models.dto.HabitDto;

public class HabitMapper {
    public static HabitDto toHabitDto(Habit habit) {
        HabitDto dto = new HabitDto();

        dto.setId(habit.getId());
        dto.setTitle(habit.getTitle());
        dto.setDescription(habit.getDescription());
        dto.setCategoryId(habit.getCategory() != null ? habit.getCategory().getId() : null);
        dto.setImage(habit.getImage());
        return dto;
    }
}
