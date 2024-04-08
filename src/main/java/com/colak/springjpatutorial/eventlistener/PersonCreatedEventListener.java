package com.colak.springjpatutorial.eventlistener;

import com.colak.springjpatutorial.jpa.Person;
import com.colak.springjpatutorial.repository.PersonRepository;
import com.colak.springjpatutorial.service.PersonCreated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonCreatedEventListener {

    private final PersonRepository repository;

    // 1. Use @EventListener if you want this work to be a part of the enclosing/original transaction
    // 2. Use @TransactionalEventListener (default phase = AFTER_COMMIT) if you want this work to be done after the enclosing transaction is committed.
    // But remember, you won’t be able to do any DB work since the original transaction has already committed.
    // Use this to do other work — send emails, send events to a messaging queue, etc.

    // 3. Use @TransactionalEventListener (default phase = AFTER_COMMIT) along with @Transactional(propagation=REQUIRES_NEW) to do DB work
    // in a new transaction after the enclosing/original transaction is committed!
    @TransactionalEventListener
    // We want to change the entity, so we need a new transaction
    // See https://dev.to/peholmst/knee-deep-in-spring-boot-transactional-event-listeners-and-cglib-proxies-1il9
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void generateVerificationToken(PersonCreated personCreated) {
        Long id = personCreated.getId();
        Person person = repository.findById(id).get();
        person.setName(STR."\{person.getName()} new");
        Person savedPerson = repository.save(person);

        log.info("Saved person : {}", savedPerson);
    }
}
