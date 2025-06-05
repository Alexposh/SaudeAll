package com.saudeall.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Appointment {
    Doctor doctor;
    Patient patient;
    Location location;
    LocalDateTime dateOfAppointment;
}
