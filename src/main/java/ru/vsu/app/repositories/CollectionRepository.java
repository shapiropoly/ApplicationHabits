package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.app.models.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {
}
