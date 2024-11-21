package ru.vsu.app.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.HabitDto;
import ru.vsu.app.services.HabitService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/habits")
@AllArgsConstructor
public class HabitController {

    private final HabitService habitService;

    // получить список привычек
    @GetMapping
    public List<HabitDto> listHabits() {
        return habitService.getAllHabits();
    }

    // добавить привычку
    @PostMapping("add_habit")
    public HabitDto addHabit(@RequestBody HabitDto habitDto) {
        return habitService.addHabit(habitDto);
    }

    // изменить привычку
    @PutMapping("update_habit")
    public Habit updateHabit(@RequestBody Habit habit) {
        return habitService.updateHabit(habit);
    }

    // удалить привычку
    @DeleteMapping("delete_habit/{id}")
    public void deleteHabit(@PathVariable Integer id) {
        habitService.deleteHabit(id);
    }

    // получить привычку по id
    @GetMapping("/{id}")
    public Habit getHabitById(@PathVariable Integer id) {
        return habitService.getHabitById(id);
    }
}
