package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.app.models.UserToHabit;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserToHabitRepository extends JpaRepository<UserToHabit, Integer> {
    Optional<UserToHabit> findByUserIdAndHabitId(Integer userId, Integer habitId);
}