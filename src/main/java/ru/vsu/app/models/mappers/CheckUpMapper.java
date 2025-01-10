package ru.vsu.app.models.mappers;

import ru.vsu.app.models.CheckUp;
import ru.vsu.app.models.UserToHabit;
import ru.vsu.app.models.dto.CheckUpDto;
import ru.vsu.app.models.dto.UserToHabitDto;

public class CheckUpMapper {
    public static CheckUpDto toCheckUpDto(CheckUp userToHabit) {
        CheckUpDto dto = new CheckUpDto();

        dto.setUserToHabitId(userToHabit.getUserToHabit().getId());
        dto.setDateCheckUp(userToHabit.getDateCheckUp());

        return dto;
    }
}
