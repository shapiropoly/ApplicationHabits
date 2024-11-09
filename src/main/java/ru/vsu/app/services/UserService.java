package ru.vsu.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vsu.app.models.User;
import ru.vsu.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void add(User user) {
        userRepository.save(user);
    }
}