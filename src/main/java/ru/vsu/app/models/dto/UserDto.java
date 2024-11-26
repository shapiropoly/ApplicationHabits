package ru.vsu.app.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String username;
    private String email;
    private LocalDate dateRegistration;
    private LocalDate dateLastActivity;


    public UserDto() {
    }

    public UserDto(String name, String username, String email,
                   LocalDate dateRegistration, LocalDate dateLastActivity) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.dateRegistration = dateRegistration;
        this.dateLastActivity = dateLastActivity;
    }
}
