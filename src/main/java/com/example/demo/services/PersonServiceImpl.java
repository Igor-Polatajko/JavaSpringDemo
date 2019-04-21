package com.example.demo.services;


import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(int id) {
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public List<Person> findByPhoneNumber(String phoneNumber) {
        return personRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Person> findByAge(int age) {
        return personRepository.findByAge(age);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(int id) {
        if (this.existsById(id)) {
            personRepository.deleteById(id);
        }
        throw new RuntimeException("Person not found");
    }

    @Override
    public boolean existsById(Integer id) {
        return personRepository.existsById(id);
    }

    @Override
    public Person updateById(int id, Person person) {
        if (this.existsById(id)) {
            return personRepository.updateById(id, person);
        }
        throw new RuntimeException("Person not found");
    }
}
