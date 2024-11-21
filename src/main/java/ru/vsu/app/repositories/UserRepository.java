package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    void deleteUserById(Integer id);
    User getUserByUsername(String username);
}
