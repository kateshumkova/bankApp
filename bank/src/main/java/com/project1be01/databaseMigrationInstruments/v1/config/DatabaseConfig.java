package com.project1be01.databaseMigrationInstruments.v1.config;


import com.project1be01.domain.Role;
import com.project1be01.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Data
@AllArgsConstructor
public class DatabaseConfig {

    private final RoleRepository roleRepository;


    public void fillRoleTable() {

        Role admin = new Role();
        admin.setName("Admin");
        roleRepository.save(admin);

        Role user = new Role();
        user.setName("User");
        roleRepository.save(user);
    }
}
