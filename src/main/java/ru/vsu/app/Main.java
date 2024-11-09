package ru.vsu.app;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vsu.app.models.User;
import ru.vsu.app.repositories.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


@Component
public class Main implements CommandLineRunner {
    public static void main(String[] args) throws ParseException {

    }

    final static int COUNT = 10;

    @Autowired
    private static UserRepository userRepository;

    @Override
    public void run(String... args) throws ParseException {



    }

//    private static List<Role> fillTableRole() {
//        List<Role> roles = new ArrayList<>();
//
//        Role roleUser = new Role("user");
//        Role roleAdmin = new Role("admin");
//
//        roles.add(roleUser);
//        roles.add(roleAdmin);
//
//        return roles;
//    }


    private static List<User> fillTableUser(UserRepository userRepository) throws ParseException {
        List<User> userList = new ArrayList<>();

        Faker faker = new Faker();

        for (int i = 0; i < 1000; i++) {
            String name = faker.name().firstName();
            String username = faker.name().username();
            String email = faker.internet().emailAddress();
            String address = faker.address().fullAddress();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date firstDate = dateFormat.parse("2024/09/01");
            Date lastDate = dateFormat.parse("2024/10/02");
            Date date1 = faker.date().between(firstDate, lastDate);
            Date date2 = faker.date().between(firstDate, lastDate);

            LocalDate dateRegistration = date1.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate dateLastActivity = date2.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            User user = new User(name, username, email, address,
                    dateRegistration, dateLastActivity);

            userList.add(user);

//            userRepository.save(user);
        }

            return userList;
    }
}
