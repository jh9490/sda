package com.sda.tracker.controllers;



import com.sda.tracker.models.Person;
import com.sda.tracker.repositories.PersonRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<Iterable<Person>> findAllUsers(@RequestParam(required = false) String dateRange, @RequestParam(required = false) String name) {
        Iterable<Person> persons =  personRepository.findAll(); 
        if(name != null){
            persons = personRepository.findByNameContaining(name);    
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
     }

     @PostMapping
     public Person savePerson(@Validated @RequestBody Person person) {
         // Implement
         return personRepository.save(person);
     }
}
