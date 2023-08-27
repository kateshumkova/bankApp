package com.project1be01.controller;


import com.project1be01.dto.taskdto.*;
import com.project1be01.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> findAllTasks(){
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findTaskById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @GetMapping(params = "managerName")
    public ResponseEntity<List<TaskResponseDTO>> findTaskByManagerName(@RequestParam String managerName) {
        return new ResponseEntity<>(taskService.findTasksByManagerName(managerName), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TaskCreateOrUpdateResponseDTO> createNewTask(@RequestBody TaskCreateRequestDTO request) {
        return new ResponseEntity<>(taskService.createTask(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TaskCreateOrUpdateResponseDTO> updateTaskById(@RequestBody TaskUpdateRequestDTO request) {
        return new ResponseEntity<>(taskService.updateTask(request), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskById(@PathVariable("id") Integer id) {
        taskService.deleteTask(id);
    }
}
