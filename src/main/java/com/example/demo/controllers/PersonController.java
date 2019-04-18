package com.example.demo.controllers;

import com.example.demo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping({"/", ""})
    @ResponseBody
    public String index(Model model) {
        model.addAttribute("text", "some text");
        return "index";
    }


}
