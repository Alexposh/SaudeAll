package com.saudeall.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.saudeall.app.model.enums.Gender;
import com.saudeall.app.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name="appointment")

//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    @JsonIgnoreProperties("appointments")
    private Doctor doctor;

    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name="patient_id")
    UUID patientId;

    @Column(name="date_of_appointment")
    LocalDateTime dateOfAppointment;

    @ManyToOne
    @JoinColumn(name="location_id")
    @JsonIgnoreProperties("appointments")
    private Location location;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
