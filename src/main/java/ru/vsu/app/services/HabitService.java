package ru.vsu.app.services;

import ru.vsu.app.models.dto.HabitDto;

import java.util.List;

public interface HabitService {

    List<HabitDto> getAllHabits();

    HabitDto addHabit(HabitDto habitDto);

    HabitDto updateHabit(Integer id, HabitDto habitDto);

    void deleteHabit(Integer id);

    HabitDto getHabitById(Integer id);
}
