package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.app.models.Habit;

public interface HabitRepository extends JpaRepository<Habit, Integer> {
}
