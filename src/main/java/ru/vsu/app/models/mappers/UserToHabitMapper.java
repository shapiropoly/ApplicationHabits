package ru.vsu.app.models.mappers;

import ru.vsu.app.models.Habit;
import ru.vsu.app.models.UserToHabit;
import ru.vsu.app.models.dto.HabitDto;
import ru.vsu.app.models.dto.UserToHabitDto;

public class UserToHabitMapper {
    public static UserToHabitDto toUserToHabitDto(UserToHabit userToHabit) {
        UserToHabitDto dto = new UserToHabitDto();

        dto.setId(userToHabit.getId());
        dto.setHabitId(userToHabit.getHabit().getId());
        dto.setUserId(userToHabit.getUser().getId());
        dto.setFrequency(userToHabit.getFrequency());
        dto.setReplay(userToHabit.getReplay());
        dto.setDateStart(userToHabit.getDateStart());

        return dto;
    }
}
