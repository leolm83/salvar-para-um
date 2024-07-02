package com.devsuperior.aula.dtos;

import com.devsuperior.aula.entities.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class PersonDepartmentDTO {

    private final Long id;
    @NotBlank
    private final String name;
    @PositiveOrZero
    private final Double salary;
    @NotNull
    private final DepartmentDTO department;
    public PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    public PersonDepartmentDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.salary = person.getSalary();
        this.department = new DepartmentDTO(person.getDepartment());
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }
}
