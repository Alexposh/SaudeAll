package com.saudeall.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class AppointmentCreationDTO {
    private UUID doctorId;
    private UUID patientId;
    private UUID location_id;
    private String dateOfAppointment;
}
