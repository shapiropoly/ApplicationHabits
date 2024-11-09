package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.app.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByTitle(String title);
}