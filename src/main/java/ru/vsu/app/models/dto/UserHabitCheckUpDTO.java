package ru.vsu.app.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserHabitCheckUpDTO {
    private int checkUpId;
    private LocalDate dateCheckUp;
    private int userToHabitId;
    private LocalDate dateStart;
    private String frequency;
    private int replay;

    public UserHabitCheckUpDTO() {
    };

    public UserHabitCheckUpDTO(int checkUpId, LocalDate dateCheckUp, int userToHabitId,
                               LocalDate dateStart, String frequency, int replay) {
        this.checkUpId = checkUpId;
        this.dateCheckUp = dateCheckUp;
        this.userToHabitId = userToHabitId;
        this.dateStart = dateStart;
        this.frequency = frequency;
        this.replay = replay;
    }
}
