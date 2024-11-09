package ru.vsu.app.utils;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vsu.app.models.Category;
import ru.vsu.app.repositories.CategoryRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FillTableCategories implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws ParseException {

//        fillTableCategory(categoryRepository);
    }

    private static void fillTableCategory(CategoryRepository categoryRepository) {
        Faker faker = new Faker();
        List<String> categories = new ArrayList<>(ParseHabit.parseCategory());

        for (int i = 0; i < categories.size(); i++) {
            String title = categories.get(faker.random().nextInt(0, categories.size() - 1));
            String description = faker.lorem().sentence();
            String image = faker.internet().image();

            Category category = new Category();
            category.setTitle(title);
            category.setDescription(description);
            category.setImage(image);

//            System.out.println("Category: " + category.getTitle() + "; Description: " + category.getDescription());

            categoryRepository.save(category);
        }
    }
}
