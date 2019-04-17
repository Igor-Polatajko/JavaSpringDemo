package com.example.demo.controllers;


import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import com.sun.javafx.collections.NonIterableChange;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class PersonController {
    private final PersonService personService;

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

    @RequestMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") int id) {
         personService.deleteById(id);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public Person add(@RequestBody Person person) {
        return personService.save(person);
    }


}
