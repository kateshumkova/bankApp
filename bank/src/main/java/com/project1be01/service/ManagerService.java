package com.project1be01.service;

import com.project1be01.domain.Manager;
import com.project1be01.domain.Role;
import com.project1be01.dto.managerdto.ManagerCreateRequestDTO;
import com.project1be01.dto.managerdto.ManagerCreateResponseDTO;
import com.project1be01.dto.managerdto.ManagerResponseDTO;
import com.project1be01.repository.ManagerRepository;
import com.project1be01.repository.RoleRepository;
import com.project1be01.service.util.ManagerConverter;
import com.project1be01.service.validation.IsAlreadyExistException;
import com.project1be01.service.validation.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerService {

    private final ManagerRepository repository;
    private final RoleRepository roleRepository;
    private final ManagerConverter converter;


    public ManagerService(ManagerRepository repository, RoleRepository roleRepository, ManagerConverter converter) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.converter = converter;
    }

    // Получить список всех пользователей
    public List<ManagerResponseDTO> findAllManagers(){
        return repository.findAll().stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    // Найти пользователя по имени
    public ManagerResponseDTO findByManagerName(String managerName) {
        Manager manager = repository.findByManagerName(managerName).orElseThrow(() -> new NotFoundException("Manager not found with name: " + managerName));
        return converter.toDto(manager);
    }

    // Найти пользователя по имени
    public Manager findByManagerNameForCreateTask(String managerName) {
        Manager manager = repository.findByManagerName(managerName).orElseThrow(() -> new NotFoundException("Manager not found with name: " + managerName));
        return manager;
    }

    // Создать нового пользователя

    public ManagerCreateResponseDTO createManager(ManagerCreateRequestDTO requestDTO){
        if (repository.findByManagerName(requestDTO.getManagerName()).isEmpty()) {
            Manager newManager = converter.fromDto(requestDTO);

            Optional<Role> defaultRole = roleRepository.findByName("user");

            if (defaultRole.isPresent()) {
                newManager.setRole(defaultRole.get());
            } else {
               throw new NotFoundException("Role 'User' not found.");
            }

            Manager savedManager = repository.save(newManager);
            return converter.toCreateDto(savedManager);
        } else {
            throw new IsAlreadyExistException("Manager with name " + requestDTO.getManagerName() + " is already exist.");
        }
    }

    // Удалить пользователя

    public void deleteManager(Integer id){
        Manager manager = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manager is not found with ID: " + id));
        repository.delete(manager);
    }

}
