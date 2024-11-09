package ru.vsu.app.controllers;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vsu.app.models.User;
import ru.vsu.app.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        User user = new User();
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", user);
        return "users";
    }



//    @GetMapping
//    public List<User> showAllUsers(Model model) {
//        return userService.getAllUsers();
//    }
}
