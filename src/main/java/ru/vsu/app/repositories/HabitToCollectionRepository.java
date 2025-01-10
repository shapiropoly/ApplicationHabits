package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.app.models.HabitToCollection;

import java.util.Optional;

public interface HabitToCollectionRepository extends JpaRepository<HabitToCollection, Integer> {
    Optional<HabitToCollection> findByHabitIdAndCollectionId(Integer habitId, Integer collectionId);
}
