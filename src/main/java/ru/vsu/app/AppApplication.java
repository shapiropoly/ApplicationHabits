package ru.vsu.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vsu.app.models.Category;
import ru.vsu.app.models.HabitDTO;
import ru.vsu.app.models.Role;
import ru.vsu.app.models.User;
import ru.vsu.app.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	private final CategoryService categoryService;

	@Autowired
	public AppApplication(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("", "", "", "", new ArrayList<Role>(List.of("admin", "user")), )
		HabitDTO habitDTO = new HabitDTO("Образ жизни", "Description", "Личностное развитие", "3432423");
		Category category = categoryService.findByTitle(habitDTO.getCategoryTitle());


		System.out.println("Название категории привычки: " + habitDTO.getCategoryTitle());
		System.out.println("service: " + categoryService);
		System.out.println("Название категории: " + category.getTitle());
	}
}
