package com.saudeall.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name="appointment")

@AllArgsConstructor
public class Appointment {
    @Id
    @UuidGenerator
    private UUID id;

    UUID doctorId;
    UUID patientId;
    UUID locationId;
    LocalDateTime dateOfAppointment;


    public Appointment(UUID id, UUID doctorId, UUID patientId, UUID locationId, LocalDate dateOfBirth){

    }
}
