package com.saudeall.app.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saudeall.app.model.Doctor;

@Service
public class DoctorService {
    public List<Doctor> getAll() {
        return Collections.emptyList();
    }

    public List<Doctor> getAllByAvailability(LocalDateTime startDate, LocalDateTime endDate) {
        return Collections.emptyList();
    }
}
