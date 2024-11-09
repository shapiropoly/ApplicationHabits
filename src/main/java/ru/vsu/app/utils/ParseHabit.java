package ru.vsu.app.utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseHabit {
    public static void main(String[] args) {
//        System.out.println(parseCategory());
    }

    public static List<String> parseCategory() {
        List<String> categories = new ArrayList<>();

        try {
            String url = "https://lifehacker.ru/203-privychki/";

            Document doc = Jsoup.connect(url).get();
            Elements categoryElements = doc.select("h2");

            if (categoryElements.isEmpty()) {
                throw new IllegalStateException("Ошибка чтения страницы.");
            } else {
                for (Element categoryElement : categoryElements) {
                    String category = categoryElement.text();
                    categories.add(category);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return categories;
    }


    public static Map<String, String> parseHabits() {
        Map<String, String> habits = new HashMap<>();

        try {
            String url = "https://lifehacker.ru/203-privychki/";

            Document doc = Jsoup.connect(url).get();
            Elements habitElements = doc.select("h3 + ol li");
            Elements categoryElements = doc.select("h2");

            if (habitElements.isEmpty()) {
                throw new IllegalStateException("Ошибка чтения страницы.");
            } else {
                for (Element habitElement : habitElements) {
                    String habit = habitElement.text().split("\\.")[0];
                    String description = habitElement.text();

                    habits.put(habit, description);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return habits;
    }
}
