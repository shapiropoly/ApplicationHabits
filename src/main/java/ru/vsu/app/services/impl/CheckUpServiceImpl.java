package ru.vsu.app.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.CheckUp;
import ru.vsu.app.models.UserToHabit;
import ru.vsu.app.models.dto.CheckUpDto;
import ru.vsu.app.models.dto.UserHabitCheckUpDTO;
import ru.vsu.app.models.mappers.CheckUpMapper;
import ru.vsu.app.repositories.CheckUpRepository;
import ru.vsu.app.repositories.UserToHabitRepository;
import ru.vsu.app.services.CheckUpService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class CheckUpServiceImpl implements CheckUpService {

    private CheckUpRepository checkUpRepository;
    private final UserToHabitRepository userToHabitRepository;

    @Override
    public List<CheckUpDto> getAllCheckUps() {
        List<CheckUp> userToHabits = checkUpRepository.findAll();
        return userToHabits.stream()
                .map(CheckUpMapper::toCheckUpDto)
                .collect(Collectors.toList());
    }

    @Override
    public CheckUpDto addCheckUp(CheckUpDto checkup) {
        CheckUp newCheckUp = new CheckUp();
        UserToHabit userToHabit = userToHabitRepository.findById(checkup.getUserToHabitId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "UserToHabit c id: "+ checkup.getUserToHabitId() + " не найден"));
        System.out.println("userToHabit: " + userToHabit.getUser() + " " + userToHabit.getHabit() + " " + userToHabit.getReplay());
        newCheckUp.setUserToHabit(userToHabit);
        newCheckUp.setDateCheckUp(checkup.getDateCheckUp());
        System.out.println("CheckUpDto dateCheckUp: " + checkup.getDateCheckUp());


        System.out.println("newCheckUp: " + newCheckUp.getDateCheckUp() + " " + newCheckUp.getUserToHabit() + " " + newCheckUp.getId());

        CheckUp savedCheckUp = checkUpRepository.save(newCheckUp);
        System.out.println("savedCheckUp: " + savedCheckUp);
        return CheckUpMapper.toCheckUpDto(savedCheckUp);
    }

    @Override
    public CheckUpDto updateCheckUp(Integer id, CheckUpDto checkup) {
        CheckUp existingCheckUp = checkUpRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Чекап c id: "+ id + " не найден"));

        UserToHabit currentUserToHabit = userToHabitRepository.findById(checkup.getUserToHabitId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "UserToHabit c id: " + checkup.getUserToHabitId() + " не найден"));


        existingCheckUp.setDateCheckUp(checkup.getDateCheckUp());
        existingCheckUp.setUserToHabit(currentUserToHabit);

        CheckUp savedCheckUp = checkUpRepository.save(existingCheckUp);
        return CheckUpMapper.toCheckUpDto(savedCheckUp);
    }

    @Transactional
    @Override
    public void deleteCheckUp(Integer id) {
        checkUpRepository.deleteById(id);
    }

    @Override
    public CheckUpDto getCheckUpById(Integer id) {
        CheckUp find = checkUpRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "CheckUp c id: "+ id + " не найден"));
        return CheckUpMapper.toCheckUpDto(find);
    }

    @Override
    public List<UserHabitCheckUpDTO> getUserHabitDetailsByUserId(Integer userId) {
        return checkUpRepository.findAllHabitDetailsByUserId(userId);
    }
}
