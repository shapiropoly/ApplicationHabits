package ru.vsu.app.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.vsu.app.models.Role;
import ru.vsu.app.repositories.RoleRepository;
import ru.vsu.app.services.RoleService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return List.of();
    }

    @Override
    public Role addRole(Role role) {
        return null;
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }

    @Override
    public void deleteRole(Integer id) {

    }
}
