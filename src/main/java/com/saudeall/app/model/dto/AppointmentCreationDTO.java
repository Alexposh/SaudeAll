package com.saudeall.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class AppointmentCreationDTO {
    private UUID doctor_id;
    private UUID patient_id;
    private UUID location_id;
    private String date_of_appointment;
}
