package com.sda.tracker.repositories;
import java.util.List;

import javax.transaction.Transactional;

import com.sda.tracker.models.Person;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PersonRepository   extends JpaRepository<Person, Long> {}
