package com.sda.tracker.services;

import java.util.List;

import com.sda.tracker.models.Meeting;
import com.sda.tracker.repositories.MeetingRepository;

public class MeetingService {
    
    public List<Meeting> findAll(MeetingRepository meetingRepository, String name){
        if(name != null){
             return meetingRepository.findByPersonNameContaining(name);
        }
        return meetingRepository.findAll();
 
    }
}

