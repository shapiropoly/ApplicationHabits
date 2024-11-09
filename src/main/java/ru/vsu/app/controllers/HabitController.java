package ru.vsu.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.Category;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.HabitDTO;
import ru.vsu.app.services.CategoryService;
import ru.vsu.app.services.HabitService;


@Controller
@RequestMapping("/habits")
public class HabitController {

    private HabitService habitService;
    private CategoryService categoryService;

    @Autowired
    public void setHabitService(HabitService habitService) {
        this.habitService = habitService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showAllHabits(Model model) {
        Habit habit = new Habit();
        model.addAttribute("habits", habitService.getAllHabits());
        model.addAttribute("habit", habit);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "habits";
    }

    @PostMapping("/add")
    public String addHabit(@ModelAttribute HabitDTO habitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "form-view";
        }

        System.out.println("Введенные данные: " + "название: " + habitDTO.getTitle() + ", категория: " + habitDTO.getCategoryTitle());
        Category category = categoryService.findByTitle(habitDTO.getCategoryTitle());

        System.out.println("Название категории введенной привычки: " + habitDTO.getCategoryTitle());
        System.out.println("Название найденной категории: " + category.getTitle());

        if (category != null) {
            Habit habit = new Habit(
                    habitDTO.getTitle(),
                    habitDTO.getDescription(),
                    category,
                    habitDTO.getImage());

            habitService.add(habit);

            return "redirect:/habits";
        } else {
            return "";
        }
    }

    @GetMapping("/show/{id}")
    public String showOneHabit(Model model, @PathVariable(value = "id") Integer id) {
        Habit habit = habitService.getById(id);
        model.addAttribute("habit", habit);
        return "habit-page";
    }
}
