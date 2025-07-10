package com.saudeall.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name="appointment")

@AllArgsConstructor
public class Appointment {
    @Id
    private UUID id;
    UUID doctorId;
    UUID patientId;
    UUID appointmentId;
    UUID locationId;
    LocalDateTime dateOfAppointment;
}
