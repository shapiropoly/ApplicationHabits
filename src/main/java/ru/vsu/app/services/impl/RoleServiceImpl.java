package ru.vsu.app.services.impl;

import jakarta.transaction.Transactional;
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
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Integer id, Role role) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Роль c id: "+ id + " не найдена"));

        existingRole.setTitle(role.getTitle());

        return roleRepository.save(existingRole);
    }

    @Transactional
    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Роль c id: "+ id + " не найдена"));
    }
}
