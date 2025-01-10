package ru.vsu.app.services;

import ru.vsu.app.models.dto.HabitToCollectionDto;

import java.util.List;

public interface HabitToCollectionService {
    List<HabitToCollectionDto> getAllHabitsToCollection();

    HabitToCollectionDto addHabitToCollection(HabitToCollectionDto habitToCollection);

    HabitToCollectionDto updateHabitToCollection(Integer id, HabitToCollectionDto habitToCollection);

    void deleteHabitToCollection(Integer id);

    HabitToCollectionDto getHabitToCollectionById(Integer id);
}
