package com.devsuperior.aula.controllers;

import com.devsuperior.aula.dtos.PersonDTO;
import com.devsuperior.aula.dtos.PersonDepartmentDTO;
import com.devsuperior.aula.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDepartmentDTO> insert(@RequestBody @Valid PersonDepartmentDTO personDepartmentDTO){
            PersonDepartmentDTO dto = personService.insert(personDepartmentDTO);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
            return  ResponseEntity.created(uri).body(dto);

    }
    @PostMapping("/no_dept")
    public ResponseEntity<PersonDTO> insert(@RequestBody @Valid PersonDTO personDTO){
        PersonDTO dto = personService.insert(personDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return  ResponseEntity.created(uri).body(dto);

    }
}
