package com.project1be01.controller;

import com.project1be01.domain.Role;
import com.project1be01.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleRequestController {

    private final RoleRepository roleRepository;

    @GetMapping
    public ResponseEntity<List<Role>> findAllRoles(){
        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }
}
