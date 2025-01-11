package ru.vsu.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.UserToHabit;
import ru.vsu.app.models.dto.UserToHabitDto;
import ru.vsu.app.services.UserToHabitService;

import java.util.List;

@RequestMapping("/api/v1/")
@AllArgsConstructor
@RestController
public class UserToHabitController {
    private final UserToHabitService userToHabitService;

    // получить список
    @GetMapping("user_to_habits")
    public List<UserToHabitDto> getAllUserToHabits() {
        return userToHabitService.getAllUserToHabits();
    }

    // добавить
    @PostMapping("add_user_to_habit")
    public UserToHabitDto addUserToHabit(@RequestBody UserToHabitDto userToHabit) {
        return userToHabitService.addUserToHabit(userToHabit);
    }

    // изменить
    @PutMapping("update_user_to_habit/{id}")
    public UserToHabitDto updateUserToHabit(@PathVariable Integer id,
                                      @RequestBody UserToHabitDto userToHabit) {
        return userToHabitService.updateUserToHabit(id, userToHabit);
    }

    @DeleteMapping("delete_user_to_habit/{id}")
    public void deleteUserToHabit(@PathVariable Integer id) {
        userToHabitService.deleteUserToHabit(id);
    }

    // получить по id
    @GetMapping("user_to_habits/{id}")
    public UserToHabit getUserToHabitById(@PathVariable Integer id) {
        return userToHabitService.getUserToHabitById(id);
    }

    // получить по id
    @GetMapping("user_to_habits/user/{user_id}")
    public List<UserToHabitDto> getListHabitsByUserId(@PathVariable("user_id") Integer userId) {
        return userToHabitService.getListHabitsByUserId(userId);
    }

}
