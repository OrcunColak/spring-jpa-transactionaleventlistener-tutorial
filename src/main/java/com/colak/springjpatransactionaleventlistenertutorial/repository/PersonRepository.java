package com.colak.springjpatransactionaleventlistenertutorial.repository;

import com.colak.springjpatransactionaleventlistenertutorial.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
