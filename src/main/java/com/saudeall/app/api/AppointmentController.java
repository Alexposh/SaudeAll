package com.saudeall.app.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.saudeall.app.model.dto.AppointmentCreationDTO;
import com.saudeall.app.model.dto.AppointmentDTO;
import com.saudeall.app.model.enums.Status;
import com.saudeall.app.services.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saudeall.app.model.Appointment;
import com.saudeall.app.services.AppointmentService;
import com.saudeall.app.services.LocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final LocationService locationService;

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return appointmentService.getAll();
    }

    @GetMapping("/appointment/{id}")
    public Appointment findById(@PathVariable UUID id) {
        return appointmentService.findById(id);
    }

    @GetMapping("/appointment/doctor/date")
    public List<Appointment> getAppointmentsByDoctorAndDate(UUID doctorId, LocalDateTime date) {
        return appointmentService.getAllByDoctorAndDate(doctorId, date);
    }

    @PostMapping("/create")
    public void createAppointment(@RequestBody AppointmentCreationDTO appointment) {
        log.info("Creating an appointment");
//        System.out.println(appointment.getDoctorId().toString());
        Appointment newAppointment = new Appointment();
        newAppointment.setDateOfAppointment(appointment.getDateOfAppointment());
        newAppointment.setStatus(Status.REQUESTED);
        newAppointment.setDoctor(doctorService.findById(appointment.getDoctorId()));
        newAppointment.setPatientId(appointment.getPatientId());
        newAppointment.setLocation(locationService.findById(appointment.getLocationId()));
//        log.info(LocalDateTime.now().toString());
//        appointment.setCreatedAt(LocalDateTime.now());
//        appointment.setStatus(Status.REQUESTED);
//        log.info(appointment.getLocation().toString());
        appointmentService.add(newAppointment);
    }

    @GetMapping("/appointment/date")
    public List<Appointment> getAppointmentsByDate(LocalDateTime date) {
        return appointmentService.getAllByDate(date);
    }

    @GetMapping("/appointment/doctor")
    public List<Appointment> getAppointmentsByDoctor(UUID doctorId) {
        return appointmentService.getAllByDoctor(doctorId);
    }

    @GetMapping("/appointment/patient/{patientId}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable UUID patientId) {
//        System.out.println(appointmentService.getAllByPatient(patientId));
        return appointmentService.getAllByPatient(patientId);
    }

    @GetMapping("/appointment/status")
    public List<Appointment> getAppointmentsByDoctorAndStatus(UUID doctorId, Boolean status) {
        return appointmentService.getAllByDoctorAndStatus(doctorId, status);
    }
}
