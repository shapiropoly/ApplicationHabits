package ru.vsu.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Habit;
import ru.vsu.app.repositories.HabitRepository;

import java.util.List;

@Service
public class HabitService {
    private HabitRepository habitRepository;

    @Autowired
    public void setHabitRepository(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public void add(Habit habit) {
        habitRepository.save(habit);
    }

    public Habit getById(Integer id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Привычка с ID " + id + " не найдена"));
    }

}
