package ru.vsu.app.services;

import ru.vsu.app.models.Role;
import ru.vsu.app.models.User;
import ru.vsu.app.models.UserToRole;
import ru.vsu.app.models.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto addUser(User user);

    UserDto updateUser(Integer id, User user);

    void deleteUser(Integer id);

    UserDto getUserById(Integer id);

    UserDto getUserByUsername(String username);

    void addRoleToUser(Integer userId, Integer roleId);

    void removeRoleFromUser(Integer userId, Integer roleId);
}