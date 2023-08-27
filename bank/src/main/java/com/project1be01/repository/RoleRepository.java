package com.project1be01.repository;

import com.project1be01.domain.Manager;
import com.project1be01.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Optional<Role> findByName(String roleName);
}
