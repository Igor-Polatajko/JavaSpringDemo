package com.example.demo;


import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoApplicationDataJpaTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void whenFindByName_thenReturnPerson() {
        // given
        Person igor = new Person("Igor", "095959595", 19);
        entityManager.persist(igor);
        entityManager.flush();

        // when
        List<Person> found = personRepository.findByName(igor.getName());

        // then
        assertThat(found.get(0).getName()).isEqualTo(igor.getName());
    }
}
