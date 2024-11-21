package ru.vsu.app.services;

import ru.vsu.app.models.HabitDto;
import ru.vsu.app.models.Habit;

import java.util.List;

public interface HabitService {

    List<HabitDto> getAllHabits();

    HabitDto addHabit(HabitDto habitDto);

    Habit updateHabit(Habit habit);

    void deleteHabit(Integer id);

    Habit getHabitById(Integer id);
}
