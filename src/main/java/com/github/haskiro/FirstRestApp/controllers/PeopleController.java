package com.github.haskiro.FirstRestApp.controllers;

import com.github.haskiro.FirstRestApp.models.Person;
import com.github.haskiro.FirstRestApp.services.PeopleService;
import com.github.haskiro.FirstRestApp.util.PersonErrorResponse;
import com.github.haskiro.FirstRestApp.util.PersonNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return peopleService.findAll(); // Jackson конвертирует эти объекты в json
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        // статус 200
        return peopleService.findOne(id);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundExceptions e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id was not found",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // статус 404
    }
}
