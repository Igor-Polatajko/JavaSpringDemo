package com.example.demo.services;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {
    Person findById(int id);

    List<Person> findByName(String name);

    List<Person> findByPhoneNumber(String phoneNumber);

    List<Person> findByAge(int age);

    List<Person> findAll();

    Person save(Person person);

    void deleteById(int id);

    boolean existsById(Integer id);

    Person updateById(int id, Person person);
}
