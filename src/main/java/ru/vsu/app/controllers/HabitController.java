package ru.vsu.app.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.dto.HabitDto;
import ru.vsu.app.services.HabitService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/habits")
@AllArgsConstructor
public class HabitController {

    private final HabitService habitService;

    // получить список привычек
    @GetMapping
    public List<HabitDto> getAllHabits() {
        return habitService.getAllHabits();
    }

    // добавить привычку
    @PostMapping("add_habit")
    public HabitDto addHabit(@RequestBody HabitDto habitDto) {
        return habitService.addHabit(habitDto);
    }

    // изменить привычку
    @PutMapping("update_habit/{id}")
    public HabitDto updateHabit(@PathVariable Integer id,
                                @RequestBody HabitDto habitDto) {
        return habitService.updateHabit(id, habitDto);
    }

    // удалить привычку
    @DeleteMapping("delete_habit/{id}")
    public void deleteHabit(@PathVariable Integer id) {
        habitService.deleteHabit(id);
    }

    // получить привычку по id
    @GetMapping("/{id}")
    public HabitDto getHabitById(@PathVariable Integer id) {
        return habitService.getHabitById(id);
    }
}
