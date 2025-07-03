package com.saudeall.app.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.saudeall.app.model.Appointment;

@Service
public class AppointmentService {
    public List<Appointment> getAll() {
        return Collections.emptyList();
    }

    public List<Appointment> getAllByDate(LocalDateTime date) {
        return Collections.emptyList();
    }

    public List<Appointment> getAllByDoctor(UUID doctorId) {
        return Collections.emptyList();
    }

    public List<Appointment> getAllByDoctorAndDate(UUID doctorId, LocalDateTime date) {
        return Collections.emptyList();
    }

    public List<Appointment> getAllByDoctorAndStatus(UUID doctorId, Boolean status) {
        return Collections.emptyList();
    }

}
