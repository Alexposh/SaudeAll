package com.saudeall.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class AppointmentCreationDTO {
    private UUID doctorId;
    private UUID patientId;
    private UUID locationId;
    private LocalDateTime dateOfAppointment;
}
