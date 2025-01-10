package ru.vsu.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.dto.HabitToCollectionDto;
import ru.vsu.app.services.HabitToCollectionService;

import java.util.List;

@RequestMapping("/api/v1/")
@AllArgsConstructor
@RestController
public class HabitToCollectionController {

    private final HabitToCollectionService habitToCollectionService;

    // получить список
    @GetMapping("habits_to_collections")
    public List<HabitToCollectionDto> getAllHabitsToCollection() {
        return habitToCollectionService.getAllHabitsToCollection();
    }

    // добавить
    @PostMapping("add_habit_to_collection")
    public HabitToCollectionDto addHabitToCollection(@RequestBody HabitToCollectionDto habitToCollection) {
        return habitToCollectionService.addHabitToCollection(habitToCollection);
    }

    // изменить
    @PutMapping("update_habit_to_collection/{id}")
    public HabitToCollectionDto updateHabitToCollection(@PathVariable Integer id,
                                         @RequestBody HabitToCollectionDto habitToCollection) {
        return habitToCollectionService.updateHabitToCollection(id, habitToCollection);
    }

    @DeleteMapping("delete_habit_to_collection/{id}")
    public void deleteHabitToCollection(@PathVariable Integer id) {
        habitToCollectionService.deleteHabitToCollection(id);
    }

    // получить по id
    @GetMapping("habit_to_collection/{id}")
    public HabitToCollectionDto getHabitToCollectionById(@PathVariable Integer id) {
        return habitToCollectionService.getHabitToCollectionById(id);
    }
}

