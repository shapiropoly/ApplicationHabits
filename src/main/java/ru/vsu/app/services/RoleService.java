package ru.vsu.app.services;

import ru.vsu.app.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();

    Role addRole(Role role);

    Role updateRole(Integer id, Role role);

    void deleteRole(Integer id);

    Role getRoleById(Integer id);
}
