package com.project1be01.domain;


import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Manager name must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Manager name can contain only latin letters and numbers")
    private String managerName;

    @NotBlank(message = "Password must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()]+$", message = "Password can contain only latin letters and numbers and some special characters")
    private String password;

    @NotBlank(message = "Email must be not blank")
    @Email(message = "Invalid email format")
    private String email;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


}
