package ru.vsu.app;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vsu.app.models.Category;
import ru.vsu.app.models.HabitDTO;
import ru.vsu.app.models.Role;
import ru.vsu.app.models.User;
import ru.vsu.app.repositories.RoleRepository;
import ru.vsu.app.repositories.UserRepository;
import ru.vsu.app.services.CategoryService;
import ru.vsu.app.services.RoleService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	private final CategoryService categoryService;
	private final RoleService roleService;

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public AppApplication(CategoryService categoryService, RoleService roleService, UserRepository userRepository, RoleRepository roleRepository) {
		this.categoryService = categoryService;
		this.roleService = roleService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		List<Role> roles = roleRepository.findAllByTitleIn(List.of("admin", "user"));

		if (roles.isEmpty()) {
			throw new RuntimeException("Не найдены роли!");
		}

		System.out.println("Роли: " + roles);

		// Создаем нового пользователя и связываем с ролями
		User user1 = new User("Bob", "bobby07", "bobby07@ya.ru", "23213", LocalDate.now(), LocalDate.now());

		// Обновляем двустороннюю связь:
		// Для каждой роли добавляем пользователя в список пользователей этой роли
		for (Role role : roles) {
			System.out.println(role.getTitle() + " " + role.getId());

			role.getUser_ids().add(user1); // Добавляем пользователя в роль
			System.out.println(user1.getId() + " " + user1.getName());
		}

		// Сохраняем пользователя
		userRepository.save(user1);
	}


}
