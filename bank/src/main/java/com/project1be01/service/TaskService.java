package com.project1be01.service;

import com.project1be01.domain.Task;
import com.project1be01.domain.Manager;
import com.project1be01.domain.TaskStatus;
import com.project1be01.dto.taskdto.*;
import com.project1be01.repository.ManagerRepository;
import com.project1be01.repository.TaskRepository;
import com.project1be01.service.util.TaskConverter;
import com.project1be01.service.validation.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    private final ManagerRepository managerRepository;
    private final TaskConverter converter;
    private final ManagerService managerService;


    // Получить список всех task

    public List<TaskResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    // Получить task по id
    public TaskResponseDTO findById(Integer id){
        Task task = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task with id: " + id + " not found"));
        return converter.toDto(task);
    }

    // получить task по имени manager

    public List<TaskResponseDTO> findTasksByManagerName(String managerName) {

        Manager manager = managerRepository.findByManagerName(managerName).orElseThrow(() -> new NotFoundException("Manager not found with name: " + managerName));

        return repository.findByManager(manager).stream()
                .map(converter::toDto)
                .collect(Collectors.toList());


    }

    // Создать новую task

    public TaskCreateOrUpdateResponseDTO createTask(TaskCreateRequestDTO requestDTO){
       Manager manager = managerService.findByManagerNameForCreateTask(requestDTO.getManagerName());
       Task newTask = converter.fromCreateRequest(requestDTO);
        newTask.setManager(manager);
        newTask.setCreateDate(LocalDateTime.now());
        newTask.setLastUpdate(LocalDateTime.now());
        newTask.setStatus(TaskStatus.Open);
       return converter.toCreateDto(repository.save(newTask));
    }

    // Обновление task
    public TaskCreateOrUpdateResponseDTO updateTask(TaskUpdateRequestDTO requestDTO){
       Task existingTask = repository.findById(requestDTO.getId())
               .orElseThrow(() -> new NotFoundException("task with id: " + requestDTO.getId() + " not found"));

       if (existingTask.getManager().getManagerName().equals(requestDTO.getManagerName())) {
           fillUpdateFields(existingTask, requestDTO);
           repository.save(existingTask);
           return converter.toCreateDto(existingTask);
        } else {
           throw new NotFoundException("manager: " + requestDTO.getManagerName() + " can't update this task.");
        }
    }

    private Task fillUpdateFields(Task existingtask,TaskUpdateRequestDTO requestDTO){
        if (requestDTO.getTaskName() != null) existingtask.setTaskName(requestDTO.getTaskName());
        if (requestDTO.getDescription() != null) existingtask.setTaskName(requestDTO.getTaskName());
        if (requestDTO.getDeadline() != null) existingtask.setTaskName(requestDTO.getTaskName());
        if (requestDTO.getStatus() != null) existingtask.setTaskName(requestDTO.getTaskName());
        existingtask.setLastUpdate(LocalDateTime.now());
        return existingtask;
    }

    // Удаление task

    public void deleteTask(Integer id){
        Task task = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("task with id: " + id + " not found"));
        repository.delete(task);
    }

}
