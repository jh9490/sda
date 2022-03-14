package com.sda.tracker.repositories;
import com.sda.tracker.models.Location;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LocationRepository   extends JpaRepository<Location, Long> {}
