package com.sda.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.sda.tracker.models.Meeting;

@Repository
public interface  MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByPersonNameContaining(@Param("name") String name);
}

