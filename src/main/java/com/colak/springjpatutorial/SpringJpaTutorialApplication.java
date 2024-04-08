package com.colak.springjpatutorial;

import com.colak.springjpatutorial.jpa.Person;
import com.colak.springjpatutorial.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringJpaTutorialApplication implements CommandLineRunner {

    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaTutorialApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Person person = new Person(1L, "person1");

        Person savedPerson = personService.save(person);
        log.info("savedPerson : {}", savedPerson);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
