package com.colak.springjpatransactionaleventlistenertutorial;

import com.colak.springjpatransactionaleventlistenertutorial.jpa.Person;
import com.colak.springjpatransactionaleventlistenertutorial.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaTransactionaleventlistenerTutorialApplication implements CommandLineRunner {

    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaTransactionaleventlistenerTutorialApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Person person = new Person(1L, "person1");

        personService.save(person);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
