package com.example.demo.services;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {
    Person findById(int id);

    List<Person> findAll();

    Person save(Person person);
}
