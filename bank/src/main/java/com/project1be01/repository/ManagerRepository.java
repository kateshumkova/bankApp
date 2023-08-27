package com.project1be01.repository;

import com.project1be01.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    public Optional<Manager> findByManagerName(String managerName);
}
