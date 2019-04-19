package com.example.demo.repositories;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.name = :name")
    List<Person> findByName(@Param("name") String name);

    @Query("SELECT p FROM Person p WHERE p.phoneNumber = :phoneNumber")
    List<Person> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT p FROM Person p WHERE p.age = :age")
    List<Person> findByAge(@Param("age") int age);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Person p SET p = :person WHERE p.id=:id")
    Person updateById(@Param("person") int id, @Param("person") Person person);
}
