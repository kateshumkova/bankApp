package com.project1be01.dto.managerdto;


import com.project1be01.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManagerResponseDTO {

    private Integer id;
    private String managerName;
    private String email;
    private Role role;

}
