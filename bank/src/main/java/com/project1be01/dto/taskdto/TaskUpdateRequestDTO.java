package com.project1be01.dto.taskdto;

import com.project1be01.domain.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateRequestDTO {

    private Integer id;
    private String taskName;
    private String description;
    private LocalDateTime deadline;
    private TaskStatus status;
    private String managerName;
}
