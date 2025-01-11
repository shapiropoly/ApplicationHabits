package ru.vsu.app.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.User;
import ru.vsu.app.models.UserToHabit;
import ru.vsu.app.models.dto.UserToHabitDto;
import ru.vsu.app.models.mappers.UserToHabitMapper;
import ru.vsu.app.repositories.HabitRepository;
import ru.vsu.app.repositories.UserRepository;
import ru.vsu.app.repositories.UserToHabitRepository;
import ru.vsu.app.services.UserToHabitService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class UserToHabitServiceImpl implements UserToHabitService {

    private UserToHabitRepository userToHabitRepository;
    private UserRepository userRepository;
    private HabitRepository habitRepository;

    @Override
    public List<UserToHabitDto> getAllUserToHabits() {
        List<UserToHabit> userToHabits = userToHabitRepository.findAll();
        return userToHabits.stream()
                .map(UserToHabitMapper::toUserToHabitDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserToHabitDto addUserToHabit(UserToHabitDto userToHabit) {
        UserToHabit newUserToHabit = new UserToHabit();
        User user = userRepository.findById(userToHabit.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(
                "User c id: "+ userToHabit.getUserId() + " не найден"));

        Habit habit = habitRepository.findById(userToHabit.getHabitId())
                .orElseThrow(() -> new IllegalArgumentException(
                "Habit c id: "+ userToHabit.getHabitId() + " не найден"));

        newUserToHabit.setUser(user);
        newUserToHabit.setHabit(habit);
        newUserToHabit.setFrequency(userToHabit.getFrequency());
        newUserToHabit.setReplay(userToHabit.getReplay());
        newUserToHabit.setDateStart(userToHabit.getDateStart());

        UserToHabit savedUserToHabit = userToHabitRepository.save(newUserToHabit);
        return UserToHabitMapper.toUserToHabitDto(savedUserToHabit);
    }

    @Override
    public UserToHabitDto updateUserToHabit(Integer id, UserToHabitDto userToHabitDto) {
        UserToHabit existingUserToHabit = userToHabitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "UserToHabit с id: " + id + " не найден"));

        User user = userRepository.findById(userToHabitDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "User с id: " + userToHabitDto.getUserId() + " не найден"));

        Habit habit = habitRepository.findById(userToHabitDto.getHabitId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Habit с id: " + userToHabitDto.getHabitId() + " не найден"));

        existingUserToHabit.setUser(user);
        existingUserToHabit.setHabit(habit);
        existingUserToHabit.setFrequency(userToHabitDto.getFrequency());
        existingUserToHabit.setReplay(userToHabitDto.getReplay());
        existingUserToHabit.setDateStart(userToHabitDto.getDateStart());

        UserToHabit updatedUserToHabit = userToHabitRepository.save(existingUserToHabit);

        return UserToHabitMapper.toUserToHabitDto(updatedUserToHabit);
    }

    @Transactional
    @Override
    public void deleteUserToHabit(Integer id) {
        userToHabitRepository.deleteById(id);
    }

    @Override
    public UserToHabit getUserToHabitById(Integer id) {
        return userToHabitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "UserToHabit c id: "+ id + " не найден"));
    }

    @Override
    public List<UserToHabitDto> getListHabitsByUserId(Integer userId) {
        return userToHabitRepository.findAll().stream()
                .filter(userToHabit -> userToHabit.getUser().getId() == userId)
                .map(UserToHabitMapper::toUserToHabitDto)
                .collect(Collectors.toList());
    }
}
