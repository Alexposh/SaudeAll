package com.saudeall.app.repository;

import com.saudeall.app.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findById(UUID idOfDoctor);
}