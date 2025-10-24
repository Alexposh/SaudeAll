package com.saudeall.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name="appointment")

@RequiredArgsConstructor
public class Appointment {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name="doctor_id")
    UUID doctor_id;
    @Column(name="patient_id")
    UUID patient_id;
    @Column(name="location_id")
    UUID location_id;

    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name="date_of_appointment")
    @JsonProperty("date_of_appointment")
    LocalDateTime dateOfAppointment;

    @CreationTimestamp
    LocalDateTime createdAt;


//    public Appointment(UUID id, UUID doctorId, UUID patientId, UUID locationId, LocalDateTime dateOfAppointment){

//    }
}
