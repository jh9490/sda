package com.sda.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sda.tracker.models.Meeting;

@Repository
public interface  MeetingRepository extends JpaRepository<Meeting, Long> {}

