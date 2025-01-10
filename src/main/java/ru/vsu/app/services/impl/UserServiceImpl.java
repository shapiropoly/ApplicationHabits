package ru.vsu.app.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.Role;
import ru.vsu.app.models.User;
import ru.vsu.app.models.UserToRole;
import ru.vsu.app.models.dto.HabitDto;
import ru.vsu.app.models.dto.UserDto;
import ru.vsu.app.models.mappers.HabitMapper;
import ru.vsu.app.models.mappers.UserMappers;
import ru.vsu.app.repositories.RoleRepository;
import ru.vsu.app.repositories.UserRepository;
import ru.vsu.app.repositories.UserToRoleRepository;
import ru.vsu.app.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserToRoleRepository userToRoleRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMappers::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto addUser(User user) {

        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setDateRegistration(user.getDateRegistration());
        userDto.setDateLastActivity(user.getDateLastActivity());

        User savedUser = userRepository.save(user);

        return UserMappers.toUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(Integer id, User user) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Пользователь с id: " + id + " не найден"));

        existingUser.setName(user.getName());
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setDateRegistration(user.getDateRegistration());
        existingUser.setDateLastActivity(user.getDateLastActivity());


        User savedUser = userRepository.save(existingUser);

        return UserMappers.toUserDto(savedUser);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserById(Integer id) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Пользователь с id: " + id + " не найден"));

        return UserMappers.toUserDto(findUser);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User findUser = userRepository.getUserByUsername(username);
        return UserMappers.toUserDto(findUser);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User findUser = userRepository.getUserByEmail(email);
        return UserMappers.toUserDto(findUser);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Роль не найдена"));

        UserToRole userToRole = new UserToRole(user, role);
        userToRoleRepository.save(userToRole);
    }

    @Transactional
    @Override
    public void removeRoleFromUser(Integer userId, Integer roleId) {
        UserToRole userToRole = userToRoleRepository.findByUserIdAndRoleId(userId, roleId)
                .orElseThrow(() -> new IllegalArgumentException("Связь не найдена"));

        userToRoleRepository.delete(userToRole);
    }

}
