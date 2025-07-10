package com.saudeall.app.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saudeall.app.model.Appointment;
import com.saudeall.app.services.AppointmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return appointmentService.getAll();
    }

    @GetMapping("/appointment/{id}")
    public Appointment findById(@PathVariable UUID id){
        return appointmentService.findById(id);
    }

    @GetMapping("/appointment/doctor/date")
    public List<Appointment> getAppointmentsByDoctorAndDate(UUID doctorId, LocalDateTime date) {
        return appointmentService.getAllByDoctorAndDate(doctorId, date);
    }

    @GetMapping("/appointment/date")
    public List<Appointment> getAppointmentsByDate(LocalDateTime date) {
        return appointmentService.getAllByDate(date);
    }

    @GetMapping("/appointment/doctor")
    public List<Appointment> getAppointmentsByDoctor(UUID doctorId) {
        return appointmentService.getAllByDoctor(doctorId);
    }

    @GetMapping("/appointment/status")
    public List<Appointment> getAppointmentsByDoctorAndStatus(UUID doctorId, Boolean status) {
        return appointmentService.getAllByDoctorAndStatus(doctorId, status);
    }
}
