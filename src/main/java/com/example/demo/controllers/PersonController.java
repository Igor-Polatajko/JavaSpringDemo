package com.example.demo.controllers;


import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("find")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @RequestMapping("find/{id}")
    public Person findById(@PathVariable("id") int id) {
        return personService.findById(id);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public Person add(@RequestBody Person person) {
        return personService.save(person);
    }


}
