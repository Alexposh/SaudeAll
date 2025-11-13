package com.saudeall.app.repository;

import com.saudeall.app.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    Clinic findById(UUID id);
}
