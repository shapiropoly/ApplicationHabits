package ru.vsu.app.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Category;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.HabitDto;
import ru.vsu.app.repositories.CategoryRepository;
import ru.vsu.app.repositories.HabitRepository;
import ru.vsu.app.services.HabitService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<HabitDto> getAllHabits() {
        return habitRepository.findAll()
                .stream()
                .map(habit -> new HabitDto(
                        habit.getId(),
                        habit.getTitle(),
                        habit.getDescription(),
                        habit.getImage(),
                        habit.getCategory().getId(),
                        habit.getCategory().getTitle()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public HabitDto addHabit(HabitDto habitDto) {
        Category category = categoryRepository.findByTitle(habitDto.getCategoryTitle())
                .orElseThrow(() -> new IllegalArgumentException("Категория с названием '" + habitDto.getCategoryTitle() + "' не найдена"));

        habitRepository.save(new Habit(
            habitDto.getTitle(),
            habitDto.getDescription(),
            category,
            habitDto.getImage()
        ));

        return habitDto;
    }

    @Override
    public Habit updateHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    @Override
    public void deleteHabit(Integer id) {
        habitRepository.deleteHabitById(id);
    }

//    @Override
//    public HabitDto getHabitById(Integer id) {
//        Habit habit = habitRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Привычка с id '" + id + "' не найдена"));
//        return new HabitDto(
//                habit.getId(),
//                habit.getTitle(),
//                habit.getDescription(),
//                habit.getImage(),
//                habit.getCategory().getId(),
//                habit.getCategory().getTitle()
//        );
//    }

    @Override
    public Habit getHabitById(Integer id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Привычка с id '" + id + "' не найдена"));
    }
}
