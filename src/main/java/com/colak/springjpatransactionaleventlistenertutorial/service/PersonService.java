package com.colak.springjpatransactionaleventlistenertutorial.service;


import com.colak.springjpatransactionaleventlistenertutorial.jpa.Person;
import com.colak.springjpatransactionaleventlistenertutorial.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Person save(Person person) {
        Person savedPerson = repository.save(person);
        applicationEventPublisher.publishEvent(new PersonCreated(savedPerson.getId()));
        return savedPerson;
    }
}
