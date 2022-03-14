package com.sda.tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.net.http.HttpHeaders;

import com.sda.tracker.models.Location;
import com.sda.tracker.models.Meeting;
import com.sda.tracker.models.Person;
import com.sda.tracker.repositories.LocationRepository;
import com.sda.tracker.repositories.MeetingRepository;
import com.sda.tracker.repositories.PersonRepository;
import com.sda.tracker.services.MeetingService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/meeting")
public class MeetingController {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private PersonRepository  personRepository;
    @Autowired
    private LocationRepository  locationRepository;
    
    private MeetingService meetingService;

    @GetMapping("/list")
    public List<Meeting> getMeeting() {
         meetingService = new  MeetingService();
         return meetingService.findAll(meetingRepository);
    } 


    @PostMapping
    public Meeting saveMeeting(@Validated @RequestBody Meeting meeting) {
        locationRepository.save(meeting.getLocation());
        if(meeting.getPerson().getId() == -1){
           meeting.setPerson(personRepository.save(new Person(meeting.getPerson().getName())));
        }
         return meetingRepository.save(meeting);
    }



}
