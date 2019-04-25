package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.services.PersonService;
import com.example.demo.services.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
public class DemoApplicationServiceTests {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    private Person igor;

    @TestConfiguration
    static class PersonServiceImplTestContextConfiguration {
        @Bean
        public PersonService personService() {
            return new PersonServiceImpl();
        }
    }

    @Before
    public void setUp() {
        igor = new Person("Igor", "095959595", 19);

        Mockito.when(personRepository.findByName(igor.getName())).thenReturn(Stream.of(igor).collect(Collectors.toList()));

        Mockito.when(personRepository.findById(igor.getId())).thenReturn(Optional.of(igor));
    }

    @Test
    public void whenValidName_thenPersonShouldBeFound() {

        List<Person> found = personService.findByName(igor.getName());

        assertThat(found.get(0).getName()).isEqualTo(igor.getName());
    }

    @Test
    public void whenValidId_thenPersonShouldBeFound() {

        Person found = personService.findById(igor.getId());

        assertThat(found.getId()).isEqualTo(igor.getId());
    }


}
