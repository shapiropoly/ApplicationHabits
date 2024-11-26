package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.app.models.Habit;
import ru.vsu.app.models.HabitDto;


@Repository
public interface HabitRepository extends JpaRepository<Habit, Integer> {
}
