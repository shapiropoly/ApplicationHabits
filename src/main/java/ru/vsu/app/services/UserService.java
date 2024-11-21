package ru.vsu.app.services;

import ru.vsu.app.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Integer id);

    User getUserById(Integer id);

    User getUserByUsername(String username);
}