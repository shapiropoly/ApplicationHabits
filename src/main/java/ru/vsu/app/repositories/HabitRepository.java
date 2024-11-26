package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.app.models.Habit;


@Repository
public interface HabitRepository extends JpaRepository<Habit, Integer> {
}
