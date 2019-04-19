package com.example.demo.controllers;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Person> persons = personService.findAll();


        persons.sort((o1, o2) ->
                o1.getName().compareTo(o2.getName())
        );


        model.addAttribute("persons", persons);
        return "index";
    }

    @RequestMapping("/create")
    public String create() {
        return "createContact";
    }
}
