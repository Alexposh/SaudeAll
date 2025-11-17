package com.saudeall.app.model;

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

@RequiredArgsConstructor
public class Appointment {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name="doctor_id")
    UUID doctorId;
    @Column(name="patient_id")
    UUID patientId;
    @Column(name="location_id")
    UUID locationId;

//    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name="date_of_appointment")
//    @JsonProperty("date_of_appointment")
    LocalDateTime dateOfAppointment;

    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;


//    public Appointment(UUID id, UUID doctorId, UUID patientId, UUID locationId, LocalDateTime dateOfAppointment){

//    }

    public enum Role {

    }
}
