package ru.vsu.app.controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.User;
import ru.vsu.app.models.UserToRole;
import ru.vsu.app.models.dto.UserDto;
import ru.vsu.app.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // получить список пользователей
    @GetMapping("users")
    public List<UserDto> listUsers() {
        return userService.getAllUsers();
    }

    // добавить пользователя
    @PostMapping("add_user")
    public UserDto addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // изменить пользователя
    @PutMapping("update_user/{id}")
    public UserDto updateUser(@PathVariable Integer id,
                                @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // удалить пользователя
    @DeleteMapping("delete_user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    // получить привычку по id
    @GetMapping("users/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // получить привычку по username
    @GetMapping("users/username/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // получить привычку по email
    @GetMapping("users/email/{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }


    // добавить роль пользователю
    @PostMapping("users/{userId}/roles/{roleId}")
    public void addRoleToUser(@PathVariable Integer userId,
                                    @PathVariable Integer roleId) {
        userService.addRoleToUser(userId, roleId);
    }

    // удалить роль у пользователя
    @DeleteMapping("users/{userId}/roles/{roleId}")
    public void removeRoleFromUser(@PathVariable Integer userId,
                                   @PathVariable Integer roleId) {
        userService.removeRoleFromUser(userId, roleId);
    }
}
