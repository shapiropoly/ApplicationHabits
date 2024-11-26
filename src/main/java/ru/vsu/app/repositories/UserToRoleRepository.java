package ru.vsu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.app.models.UserToRole;

import java.util.Optional;

public interface UserToRoleRepository extends JpaRepository<UserToRole, Integer> {
    Optional<UserToRole> findByUserIdAndRoleId(Integer userId, Integer roleId);
}

