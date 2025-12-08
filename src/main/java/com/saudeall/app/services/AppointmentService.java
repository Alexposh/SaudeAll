package com.saudeall.app.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.saudeall.app.model.dto.AppointmentCreationDTO;
import com.saudeall.app.model.enums.Status;
import com.saudeall.app.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.saudeall.app.model.Appointment;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final LocationService locationService;

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public void add(AppointmentCreationDTO appointment){
        Appointment newAppointment = new Appointment();
        newAppointment.setDateOfAppointment(appointment.getDateOfAppointment());
        newAppointment.setDoctor(doctorService.findById(appointment.getDoctorId()));
        newAppointment.setPatientId(appointment.getPatientId());
        newAppointment.setLocation(locationService.findById(appointment.getLocationId()));
        newAppointment.setCreatedAt(LocalDateTime.now());
        newAppointment.setStatus(Status.REQUESTED);
        appointmentRepository.save(newAppointment);
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

    public List<Appointment> getAllByPatient(UUID patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAllByDoctorAndDate(UUID doctorId, LocalDateTime date) {
        return Collections.emptyList();
    }

    public List<Appointment> getAllByDoctorAndStatus(UUID doctorId, Boolean status) {
        return Collections.emptyList();
    }

}
