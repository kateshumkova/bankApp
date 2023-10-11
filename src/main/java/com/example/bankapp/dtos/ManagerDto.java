package com.example.bankapp.dtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter

public class ManagerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private int status;
    private Date createdAt;
    private Date updatedAt;

}
