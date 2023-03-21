package com.github.haskiro.FirstRestApp.services;

import com.github.haskiro.FirstRestApp.models.Person;
import com.github.haskiro.FirstRestApp.repositories.PeopleRepository;
import com.github.haskiro.FirstRestApp.util.PersonNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson =  peopleRepository.findById(id);

        return foundPerson.orElseThrow(PersonNotFoundExceptions::new);
    }
}
