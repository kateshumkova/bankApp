package com.project1be01.controller;


import com.project1be01.dto.managerdto.ManagerResponseDTO;
import com.project1be01.dto.taskdto.TaskResponseDTO;
import com.project1be01.service.ManagerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/managers")
public class AdminController {

    private final ManagerService managerService;

    @GetMapping
    public ResponseEntity<List<ManagerResponseDTO>> findAllManagers(){
        return new ResponseEntity<>(managerService.findAllManagers(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ManagerResponseDTO> findManagerByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(managerService.findByManagerName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManagerById(@PathVariable("id") Integer id) {
        managerService.deleteManager(id);
    }


    }
