package ru.vsu.app.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class UserToHabitDto {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("habit_id")
    private int habitId;

    private String frequency;

    private int replay;

    @JsonProperty("data_start")
    private LocalDate dateStart;

    public UserToHabitDto() {
    }

    public UserToHabitDto(int userId, int habitId, String frequency,
                          int replay, LocalDate dateStart) {
        this.userId = userId;
        this.habitId = habitId;
        this.frequency = frequency;
        this.replay = replay;
        this.dateStart = dateStart;
    }
}
