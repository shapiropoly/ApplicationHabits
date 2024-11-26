package ru.vsu.app.models.mappers;

import ru.vsu.app.models.Role;
import ru.vsu.app.models.User;
import ru.vsu.app.models.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserMappers {
    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();

        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setDateRegistration(user.getDateRegistration());
        dto.setDateLastActivity(user.getDateLastActivity());

        return dto;
    }
}
