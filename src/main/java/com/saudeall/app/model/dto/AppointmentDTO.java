package com.saudeall.app.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class AppointmentDTO {
    @Column(name = "id")
    private UUID appointmentId;
    @Column(name = "first_name")
    private String doctorFirstName;
    @Column(name = "last_name")
    private String doctorLastName;
    @Column(name = "image")
    private String doctorImage;
    @Column(name = "appointment_status")
    private String appointmentStatus;
    @Column(name = "date_of_appointment")
    private LocalDateTime dateOfAppointment;
    @Column(name = "location_name")
    private String clinicName;
}
