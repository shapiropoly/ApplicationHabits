package ru.vsu.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.CheckUp;
import ru.vsu.app.models.dto.CheckUpDto;
import ru.vsu.app.models.dto.UserHabitCheckUpDTO;
import ru.vsu.app.services.CheckUpService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class CheckUpController {
    private final CheckUpService checkUpService;

    @GetMapping("checkups")
    public List<CheckUpDto> getAllCheckUps() {
        return checkUpService.getAllCheckUps();
    }

    @PostMapping("add_checkup")
    public CheckUpDto addCheckUp(@RequestBody CheckUpDto checkup) {
        return checkUpService.addCheckUp(checkup);
    }

    @PutMapping("update_checkup/{id}")
    public CheckUpDto updateCheckUp(@PathVariable Integer id,
                                      @RequestBody CheckUpDto checkup) {
        return checkUpService.updateCheckUp(id, checkup);
    }

    @DeleteMapping("delete_checkup/{id}")
    public void deleteCheckUp(@PathVariable("id") Integer id) {
        checkUpService.deleteCheckUp(id);
    }

    // получить чекап по id
    @GetMapping("checkups/{id}")
    public CheckUpDto getCheckUpById(@PathVariable("id") Integer id) {
        return checkUpService.getCheckUpById(id);
    }

    // получить чекап по user_id
    @GetMapping("checkups/user/{userId}")
    public List<UserHabitCheckUpDTO> getCheckUpsByUserId(@PathVariable("userId") Integer userId) {
        return checkUpService.getUserHabitDetailsByUserId(userId);
    }
}
