package com.saudeall.app.repository;

import com.saudeall.app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findById(UUID idOfPatient);


}