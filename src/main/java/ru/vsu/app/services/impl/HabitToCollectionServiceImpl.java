package ru.vsu.app.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.*;
import ru.vsu.app.models.dto.HabitToCollectionDto;
import ru.vsu.app.models.mappers.HabitToCollectionMapper;
import ru.vsu.app.repositories.CollectionRepository;
import ru.vsu.app.repositories.HabitRepository;
import ru.vsu.app.repositories.HabitToCollectionRepository;
import ru.vsu.app.services.HabitToCollectionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class HabitToCollectionServiceImpl implements HabitToCollectionService {

    private HabitToCollectionRepository habitToCollectionRepository;
    private HabitRepository habitRepository;
    private CollectionRepository collectionRepository;

    @Override
    public List<HabitToCollectionDto> getAllHabitsToCollection() {
        List<HabitToCollection> habitToCollection = habitToCollectionRepository.findAll();
        return habitToCollection.stream()
                .map(HabitToCollectionMapper::toHabitToCollectionDto)
                .collect(Collectors.toList());
    }

    @Override
    public HabitToCollectionDto addHabitToCollection(HabitToCollectionDto habitToCollection) {
        HabitToCollection newHabitToCollection = new HabitToCollection();

        Habit habit = habitRepository.findById(habitToCollection.getHabitId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Habit c id: "+ habitToCollection.getHabitId() + " не найден"));

        Collection collection = collectionRepository.findById(habitToCollection.getCollectionId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Collection c id: "+ habitToCollection.getCollectionId() + " не найден"));

        newHabitToCollection.setCollection(collection);
        newHabitToCollection.setHabit(habit);

        HabitToCollection savedHabitToCollection = habitToCollectionRepository.save(newHabitToCollection);
        return HabitToCollectionMapper.toHabitToCollectionDto(savedHabitToCollection);
    }

    @Override
    public HabitToCollectionDto updateHabitToCollection(Integer id, HabitToCollectionDto habitToCollection) {
        HabitToCollection existingHabitToCollection = habitToCollectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "HabitToCollection с id: " + id + " не найден"));


        Habit habit = habitRepository.findById(habitToCollection.getHabitId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Habit c id: "+ habitToCollection.getHabitId() + " не найден"));

        Collection collection = collectionRepository.findById(habitToCollection.getCollectionId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Collection c id: "+ habitToCollection.getCollectionId() + " не найден"));

        existingHabitToCollection.setCollection(collection);
        existingHabitToCollection.setHabit(habit);

        HabitToCollection updatedHabitToCollection = habitToCollectionRepository.save(existingHabitToCollection);
        return HabitToCollectionMapper.toHabitToCollectionDto(updatedHabitToCollection);
    }

    @Override
    public void deleteHabitToCollection(Integer id) {
        habitToCollectionRepository.deleteById(id);
    }

    @Override
    public HabitToCollectionDto getHabitToCollectionById(Integer id) {
        HabitToCollection find = habitToCollectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "HabitToCollection c id: "+ id + " не найден"));
        return HabitToCollectionMapper.toHabitToCollectionDto(find);
    }
}
