package com.lft.spring.cloud.feign.client.controller;

import com.lft.spring.cloud.feign.api.domain.Person;
import com.lft.spring.cloud.feign.api.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PersonClientController implements PersonService {

    private final PersonService personService;

    public PersonClientController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person/save")
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/person/find/all")
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
