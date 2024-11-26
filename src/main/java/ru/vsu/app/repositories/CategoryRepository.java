package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.app.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}