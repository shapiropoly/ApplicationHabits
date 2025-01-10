package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.app.models.HabitToCollection;

import java.util.Optional;

@Repository
public interface HabitToCollectionRepository extends JpaRepository<HabitToCollection, Integer> {
    Optional<HabitToCollection> findByHabitIdAndCollectionId(Integer habitId, Integer collectionId);
}
