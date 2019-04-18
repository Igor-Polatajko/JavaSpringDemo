package com.example.demo.controllers;


import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class PersonRestController {
    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("find")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @RequestMapping("find/id/{id}")
    public Person findById(@PathVariable("id") int id) {
        return personService.findById(id);
    }

    @RequestMapping("find/name/{name}")
    public List<Person> findByName(@PathVariable("name") String name) {
        return personService.findByName(name);
    }

    @RequestMapping("find/number/{phoneNumber}")
    public List<Person> findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return personService.findByPhoneNumber(phoneNumber);
    }

    @RequestMapping("find/age/{age}")
    public List<Person> findByAge(@PathVariable("age") int age) {
        return personService.findByAge(age);
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
