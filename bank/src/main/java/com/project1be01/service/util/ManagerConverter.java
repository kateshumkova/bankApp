package com.project1be01.service.util;

import com.project1be01.domain.Manager;

import com.project1be01.dto.managerdto.ManagerCreateRequestDTO;
import com.project1be01.dto.managerdto.ManagerCreateResponseDTO;
import com.project1be01.dto.managerdto.ManagerResponseDTO;
import org.springframework.stereotype.Service;


@Service
public class ManagerConverter {

    public ManagerCreateResponseDTO toCreateDto(Manager manager){
        return new ManagerCreateResponseDTO(manager.getId(), manager.getManagerName(),manager.getRole().getName());
    }

    public ManagerResponseDTO toDto(Manager manager){
        return new ManagerResponseDTO(manager.getId(), manager.getManagerName(), manager.getEmail(), manager.getRole());
    }

    public Manager fromDto(ManagerCreateRequestDTO dto){
        Manager newManager = new Manager();
        if (dto.getManagerName() != null) {
            newManager.setManagerName(dto.getManagerName());
        }
        if (dto.getPassword() != null) {
            newManager.setPassword(dto.getPassword());
        }
        if (dto.getEmail() != null) {
            newManager.setEmail(dto.getEmail());
        }

        return newManager;
    }
}
