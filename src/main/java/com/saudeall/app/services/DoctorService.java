package com.saudeall.app.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.saudeall.app.model.Doctor;
import com.saudeall.app.repository.DoctorRepository;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public static UUID generateRandomUUID() {
        return UUID.randomUUID();
    }


    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getAllByAvailability(LocalDateTime startDate, LocalDateTime endDate) {
        return Collections.emptyList();
    }

    public void add(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Doctor findById(UUID idOfDoctor) {
        return doctorRepository.findById(idOfDoctor);
    }
}
