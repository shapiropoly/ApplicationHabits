package ru.vsu.app.services;

import ru.vsu.app.models.dto.CheckUpDto;
import ru.vsu.app.models.dto.UserHabitCheckUpDTO;

import java.util.List;

public interface CheckUpService {
    List<CheckUpDto> getAllCheckUps();

    CheckUpDto addCheckUp(CheckUpDto checkup);

    CheckUpDto updateCheckUp(Integer id, CheckUpDto checkup);

    void deleteCheckUp(Integer id);

    CheckUpDto getCheckUpById(Integer id);

    List<UserHabitCheckUpDTO> getUserHabitDetailsByUserId(Integer userId);
}
