package com.devsuperior.aula.dtos;

import com.devsuperior.aula.entities.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class DepartmentDTO {
    @NotNull
    @PositiveOrZero
    private final Long id;
    @NotBlank
    private final String name;

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
