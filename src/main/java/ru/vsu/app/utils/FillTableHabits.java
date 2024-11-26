//package ru.vsu.app.utils;
//
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import ru.vsu.app.models.Habit;
//import ru.vsu.app.models.Category;
//import ru.vsu.app.repositories.CategoryRepository;
//import ru.vsu.app.repositories.HabitRepository;
//
//import java.text.ParseException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//@Component
//public class FillTableHabits implements CommandLineRunner {
//
//    final static int COUNT = 10;
//
//    @Autowired
//    private HabitRepository habitRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Override
//    public void run(String... args) throws ParseException {
//
////        fillTableHabit(habitRepository);
////        fillTableCategory(categoryRepository);
//
//    }
//
//    private void fillTableHabit(HabitRepository habitRepository) throws ParseException {
//
//        Faker faker = new Faker();
//        Map<String, String> habitsData = new HashMap<>(ParseHabit.parseHabits());
//        Random random = new Random();
//
//        for (int i = 0; i < COUNT; i++) {
//            int randomValue = random.nextInt(habitsData.size());
//            Map.Entry<String, String> randomHabit = (Map.Entry<String, String>) habitsData.entrySet().toArray()[randomValue];
//
//            String title = randomHabit.getKey();
//            String description = randomHabit.getValue();
//            String image = faker.internet().image();
//
//            Category category = findRandomCategory();
//
//            Habit habit = new Habit(title, description, category, image);
//
////            System.out.println("Title: " + habit.getTitle() + "; Description: "
////                    + habit.getDescription() + "; Category: " + habit.getCategory().getTitle() + "; Img: " + habit.getImage());
//
//            habitRepository.save(habit);
//        }
//
//    }
//
//    private Category findRandomCategory() {
//        List<Category> categories = categoryRepository.findAll();
//        return categories.get(new Random().nextInt(categories.size()));
//    }
//}
