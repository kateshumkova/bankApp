package com.project1be01.controller;


import com.project1be01.dto.managerdto.ManagerCreateRequestDTO;
import com.project1be01.dto.managerdto.ManagerCreateResponseDTO;
import com.project1be01.service.ManagerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public ResponseEntity<ManagerCreateResponseDTO> createNewManager(@Valid @RequestBody ManagerCreateRequestDTO request) {
        return new ResponseEntity<>(managerService.createManager(request), HttpStatus.CREATED);
    }
}
