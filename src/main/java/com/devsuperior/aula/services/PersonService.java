package com.devsuperior.aula.services;

import com.devsuperior.aula.dtos.PersonDTO;
import com.devsuperior.aula.dtos.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final DepartmentRepository departmentRepository;

    public PersonService(PersonRepository personRepository, DepartmentRepository departmentRepository) {
        this.personRepository = personRepository;
        this.departmentRepository = departmentRepository;
    }

    public PersonDepartmentDTO insert(PersonDepartmentDTO personDepartmentDTO){
        Person person = new Person();
        person.setName(personDepartmentDTO.getName());
        person.setSalary(personDepartmentDTO.getSalary());
//        Department department = new Department();
        Department department = departmentRepository.getReferenceById(personDepartmentDTO.getDepartment().getId());
//        department.setId(personDepartmentDTO.getDepartment().getId());
//        department.setName(personDepartmentDTO.getDepartment().getName());
        person.setDepartment(department);
        person = personRepository.save(person);
        return new PersonDepartmentDTO(person);
    }

    public PersonDTO insert(PersonDTO personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setSalary(personDTO.getSalary());
        Department department = departmentRepository.getReferenceById(personDTO.getDepartmentId());
        person.setDepartment(department);
        person = personRepository.save(person);
        return new PersonDTO(person);
    }
}
