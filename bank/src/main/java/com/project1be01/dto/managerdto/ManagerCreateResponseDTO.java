package com.project1be01.dto.managerdto;


import com.project1be01.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ManagerCreateResponseDTO {

    private Integer id;
    private String managerName;
    private String roleName;

}
