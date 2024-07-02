package com.devsuperior.aula.dtos;

import com.devsuperior.aula.entities.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class PersonDTO {

    private final Long id;
    @NotBlank
    private final String name;
    @PositiveOrZero
    private final Double salary;
    @NotNull
    @Positive
    private final Long departmentId;

    public PersonDTO(Long id, String name, Double salary, Long departmentId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departmentId = departmentId;
    }
    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.salary = person.getSalary();
        this.departmentId = person.getDepartment().getId();
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Long getId() {
        return id;
    }
}
