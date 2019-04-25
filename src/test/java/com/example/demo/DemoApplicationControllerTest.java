package com.example.demo;

import com.example.demo.controllers.PersonRestController;
import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
public class DemoApplicationControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService service;

    @Test
    public void givenPersons_whenGetPersons_thenReturnJsonArray() throws Exception {

        Person igor = new Person("Igor", "095959595", 19);
        Person user = new Person("User", "050505050", 19);

        List<Person> allPersons = Stream.of(igor, user).collect(Collectors.toList());

        given(service.findAll()).willReturn(allPersons);

        mvc.perform(get("/api/find")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value(igor.getName()))
                .andExpect(jsonPath("$[1].name").value(user.getName()));
    }
}
