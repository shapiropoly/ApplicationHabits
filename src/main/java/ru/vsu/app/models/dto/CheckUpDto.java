package ru.vsu.app.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CheckUpDto {
    @JsonProperty("user_to_habit_id")
    private int userToHabitId;

    @JsonProperty("date_check")
    private LocalDate dateCheckUp;

    public CheckUpDto() {
    }

    public CheckUpDto(int userToHabitId, LocalDate dateCheckUp) {
        this.userToHabitId = userToHabitId;
        this.dateCheckUp = dateCheckUp;
    }
}
