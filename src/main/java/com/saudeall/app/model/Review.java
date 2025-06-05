package com.saudeall.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Review {
    private Doctor doctor;
    private Patient patient;
    private Appointment appointment;
    private int rating;
}
