package com.example.demo.controllers;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("text", "some text");
        return "index";
    }
    
}
