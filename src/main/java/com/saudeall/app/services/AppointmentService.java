package com.saudeall.app.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.saudeall.app.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.saudeall.app.model.Appointment;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public void add(Appointment appointment){
        appointmentRepository.save(appointment);
    }

    public Appointment findById(UUID idOfAppointment){
        return appointmentRepository.findById(idOfAppointment);
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
