package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.app.models.CheckUp;
import ru.vsu.app.models.dto.UserHabitCheckUpDTO;

import java.util.List;

@Repository
public interface CheckUpRepository extends JpaRepository<CheckUp, Integer> {
    @Query("SELECT new ru.vsu.app.models.dto.UserHabitCheckUpDTO(" +
            "c.id, c.dateCheckUp, u.user.id, u.habit.id, u.dateStart, u.frequency, u.replay) " +
            "FROM CheckUp c " +
            "JOIN c.userToHabit u " +
            "WHERE u.user.id = :userId")
    List<UserHabitCheckUpDTO> findAllHabitDetailsByUserId(@Param("userId") Integer userId);
}