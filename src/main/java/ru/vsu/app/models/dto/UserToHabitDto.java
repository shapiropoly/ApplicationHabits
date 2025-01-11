package ru.vsu.app.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class UserToHabitDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("habit_id")
    private int habitId;

    private String frequency;

    private int replay;

    @JsonProperty("date_start")
    private LocalDate dateStart;

    public UserToHabitDto() {
    }

    public UserToHabitDto(int id, int userId, int habitId, String frequency,
                          int replay, LocalDate dateStart) {
        this.id = id;
        this.userId = userId;
        this.habitId = habitId;
        this.frequency = frequency;
        this.replay = replay;
        this.dateStart = dateStart;
    }
}
