package com.project1be01.domain;

import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name must be not blank")
    @Size(min = 3, max = 15, message = "Name length must be between 3 and 15")
    private String taskName;

    @NotBlank(message = "Description must be not blank")
    @Size(min = 1, max = 25, message = "Description length must be between 1 and 25")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;

    @NotNull(message = "Deadline must be not blank/null")
    private LocalDateTime deadline;

    private TaskStatus status;

}
