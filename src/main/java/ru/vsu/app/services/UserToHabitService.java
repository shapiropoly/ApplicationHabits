package ru.vsu.app.services;

import ru.vsu.app.models.UserToHabit;
import ru.vsu.app.models.dto.UserToHabitDto;

import java.util.List;

public interface UserToHabitService {
    List<UserToHabitDto> getAllUserToHabits();

    UserToHabitDto addUserToHabit(UserToHabitDto userToHabit);

    UserToHabitDto updateUserToHabit(Integer id, UserToHabitDto userToHabit);

    void deleteUserToHabit(Integer id);

    UserToHabit getUserToHabitById(Integer id);

    List<UserToHabitDto> getListHabitsByUserId(Integer userId);
}
