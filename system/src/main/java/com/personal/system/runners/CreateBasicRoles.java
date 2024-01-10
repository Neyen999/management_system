package com.personal.system.runners;

import com.personal.system.enums.Roles;
import com.personal.system.models.Role;
import com.personal.system.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CreateBasicRoles implements CommandLineRunner {
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public void run(String... args) throws Exception {
        createBasicRoles();
    }

    void createBasicRoles() {
        for (Roles role: Roles.values()) {
            if (!rolesRepository.existsByName(role.name())) {
                Role newRole = new Role();
                newRole.setName(role.name());

                rolesRepository.save(newRole);
            }
        }
    }
}
