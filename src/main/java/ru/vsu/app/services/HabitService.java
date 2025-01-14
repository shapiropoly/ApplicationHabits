package ru.vsu.app.services;

import org.springframework.web.bind.annotation.PathVariable;
import ru.vsu.app.models.dto.HabitDto;

import java.util.List;

public interface HabitService {

    List<HabitDto> getAllHabits();

    HabitDto addHabit(HabitDto habitDto);

    HabitDto updateHabit(Integer id, HabitDto habitDto);

    void deleteHabit(Integer id);

    List<HabitDto> getHabitsByCollectionId(Integer collectionId);

    HabitDto getHabitById(Integer id);
}
