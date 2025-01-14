package ru.vsu.app.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.dto.HabitDto;
import ru.vsu.app.models.mappers.HabitMapper;
import ru.vsu.app.repositories.CategoryRepository;
import ru.vsu.app.repositories.HabitRepository;
import ru.vsu.app.repositories.HabitToCollectionRepository;
import ru.vsu.app.services.HabitService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;
    private final HabitToCollectionRepository habitToCollectionRepository;
    private final CategoryRepository categoryRepository;

    // Получить список привычек
    @Override
    public List<HabitDto> getAllHabits() {
        List<Habit> habits = habitRepository.findAll();
        return habits.stream()
                .map(HabitMapper::toHabitDto)
                .collect(Collectors.toList());
    }

    // Добавить привычку
    @Override
    public HabitDto addHabit(HabitDto habitDto) {
        Habit habit = new Habit();

        habit.setTitle(habitDto.getTitle());
        habit.setDescription(habitDto.getDescription());

        if (habitDto.getCategoryId() != null) {
            habit.setCategory(categoryRepository.findById(habitDto.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Категория не найдена")));
        }

        habit.setImage(habitDto.getImage());

        Habit savedHabit = habitRepository.save(habit);

        return HabitMapper.toHabitDto(savedHabit);
    }

    // Обновить привычку
    @Override
    public HabitDto updateHabit(Integer id, HabitDto habitDto) {
        Habit existingHabit = habitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Привычка с id " + id + " не найдена"));

        existingHabit.setTitle(habitDto.getTitle());
        existingHabit.setDescription(habitDto.getDescription());

        if (habitDto.getCategoryId() != null) {
            existingHabit.setCategory(categoryRepository.findById(habitDto.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Категория не найдена")));
        }

        existingHabit.setImage(habitDto.getImage());

        Habit updatedHabit = habitRepository.save(existingHabit);

        return HabitMapper.toHabitDto(updatedHabit);
    }

    @Transactional
    @Override
    public void deleteHabit(Integer id) {
        habitRepository.deleteById(id);
    }

    @Override
    public List<HabitDto> getHabitsByCollectionId(Integer collectionId) {
        return habitToCollectionRepository.findAll().stream()
                .filter(habitToCollection -> habitToCollection.getCollection().getId()== collectionId)
                .map(habitToCollection -> {
                    Habit habit = habitToCollection.getHabit();
                    return HabitMapper.toHabitDto(habit);
                })
                .collect(Collectors.toList());
    }


    @Override
    public HabitDto getHabitById(Integer id) {
        Habit findHabit = habitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Привычка с id '" + id + "' не найдена"));

        return HabitMapper.toHabitDto(findHabit);
    }
}
