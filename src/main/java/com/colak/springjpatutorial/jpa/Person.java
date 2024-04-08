package com.colak.springjpatutorial.jpa;

import com.colak.springjpatutorial.service.PersonCreated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table(name = "person")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person extends AbstractAggregateRoot<Person> {
    @Id
    private Long id;
    private String name;

    // Attributes of Entity
    public void publishEvent() {
        registerEvent(new PersonCreated(this.getId()));
    }
}
