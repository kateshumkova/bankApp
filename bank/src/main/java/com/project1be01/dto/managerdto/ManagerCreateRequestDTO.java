package com.project1be01.dto.managerdto;

import com.project1be01.domain.Role;
import com.project1be01.domain.Task;
import lombok.Data;

import java.util.List;

@Data
public class ManagerCreateRequestDTO {

    private String managerName;
    private String password;
    private String email;

}
