package com.saudeall.app.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private UUID id;

    private int rating;

    //private Patient patient;
    //private Appointment appointment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}
