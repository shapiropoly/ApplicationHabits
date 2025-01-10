package ru.vsu.app.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vsu.app.models.Role;
import ru.vsu.app.services.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    // получить список ролей
    @GetMapping("roles")
    public List<Role> listRoles() {
        return roleService.getAllRole();
    }

    // добавить пользователя
    @PostMapping("add_role")
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    // изменить роль
    @PutMapping("update_role/{id}")
    public Role updateRole(@PathVariable Integer id,
                              @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    // удалить роль
    @DeleteMapping("delete_role/{id}")
    public void deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
    }

    // получить роль по id
    @GetMapping("roles/{id}")
    public Role getRoleById(@PathVariable Integer id) {
        return roleService.getRoleById(id);
    }
}
