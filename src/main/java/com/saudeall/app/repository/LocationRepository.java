package com.saudeall.app.repository;

import com.saudeall.app.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findById(UUID idOfLocation);
}
