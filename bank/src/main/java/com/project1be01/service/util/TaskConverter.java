package com.project1be01.service.util;

import com.project1be01.domain.Task;
import com.project1be01.dto.managerdto.ManagerCreateResponseDTO;
import com.project1be01.dto.taskdto.TaskCreateOrUpdateResponseDTO;
import com.project1be01.dto.taskdto.TaskCreateRequestDTO;
import com.project1be01.dto.taskdto.TaskResponseDTO;
import com.project1be01.dto.taskdto.TaskUpdateRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskConverter {

    public TaskCreateOrUpdateResponseDTO toCreateDto(Task task) {
        TaskCreateOrUpdateResponseDTO dto = new TaskCreateOrUpdateResponseDTO();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setDescription(task.getDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());
        dto.setManagerCreateResponseDTO(new ManagerCreateResponseDTO(
                task.getManager().getId(),
                task.getManager().getManagerName(),
                task.getManager().getRole().getName()));

        return dto;
    }

    public TaskResponseDTO toDto(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setDescription(task.getDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());

        return dto;
    }

    public Task fromCreateRequest(TaskCreateRequestDTO dto){
        Task task = new Task();
        if (dto.getTaskName() != null) {
            task.setTaskName(dto.getTaskName());
        }
        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getDeadline() != null) {
            task.setDeadline(dto.getDeadline());
        }

        return task;
    }

    public Task fromUpdateRequest(TaskUpdateRequestDTO dto){
        Task task = new Task();
        if (dto.getId() != null) {
            task.setId(dto.getId());
        }

        if (dto.getTaskName() != null) {
            task.setTaskName(dto.getTaskName());
        }
        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getDeadline() != null) {
            task.setDeadline(dto.getDeadline());
        }
        if (dto.getStatus() != null) {
            task.setStatus(dto.getStatus());
        }
        return task;
    }

}
