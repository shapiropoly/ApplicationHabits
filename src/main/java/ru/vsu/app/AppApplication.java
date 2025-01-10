package ru.vsu.app;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vsu.app.models.*;
import ru.vsu.app.repositories.CategoryRepository;
import ru.vsu.app.repositories.HabitRepository;
import ru.vsu.app.repositories.RoleRepository;
import ru.vsu.app.repositories.UserRepository;
import ru.vsu.app.services.CategoryService;
import ru.vsu.app.services.CollectionService;
import ru.vsu.app.services.HabitService;
import ru.vsu.app.services.RoleService;

import java.util.List;


@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	private final CategoryService categoryService;
	private final CollectionService collectionService;
	private final RoleService roleService;
	private final HabitService habitService;

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final CategoryRepository categoryRepository;
	private final HabitRepository habitRepository;

	@Autowired
	public AppApplication(
			CategoryService categoryService,
			CollectionService collectionService,
			RoleService roleService,
			UserRepository userRepository,
			RoleRepository roleRepository,
			CategoryRepository categoryRepository,
			HabitService habitService,
			HabitRepository habitRepository) {

		this.categoryService = categoryService;
		this.collectionService = collectionService;
		this.roleService = roleService;
		this.habitService = habitService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
		this.categoryRepository = categoryRepository;
		this.habitRepository = habitRepository;
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

//		UserToHabit userToHabit1 = new UserToHabit()

//		System.out.println("Роли: " + roles);

//		Category c1 = new Category("Здоровье", "Здоровье и все, что с ним связано", "2382392");
//		Category c2 = new Category("Отношения", "Отношения и все, что с ними связано", "8943294");
//		Category c3 = new Category("Спорт", "Спорт и все, что с ним связано", "6272538");
//		Category c4 = new Category("Осознанность", "Привычки для осознанности", "93348732");


//		categoryRepository.save(c1);
//		categoryRepository.save(c2);
//		categoryRepository.save(c4);

//		HabitDTO habit1 = new HabitDTO("Читать 15 минут в день", "Чтение", "Осознанность", "93892432");
//
//		Category category = categoryService.findByTitle(habit1.getCategoryTitle());
//
//		System.out.println("Название категории введенной привычки: " + habit1.getCategoryTitle());
//
//		if (category != null) {
//			Habit habit = new Habit(
//					habit1.getTitle(),
//					habit1.getDescription(),
//					category,
//					habit1.getImage());
//
//			habitRepository.save(habit);
//		}



//		User user1 = new User("Bob", "bobby07", "bobby07@ya.ru", "23213", LocalDate.now(), LocalDate.now());
//
//		for (Role role : roles) {
//			role.getUser_ids().add(user1);
//		}
//
//		userRepository.save(user1);
	}
}
