package com.saudeall.app.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saudeall.app.model.Patient;
import com.saudeall.app.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public void add() {
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setPicture("https://example.com/picture.jpg");
        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patient.setIban("DE89370400440532013000");
        patient.setContactDetails("john.doe@company.com");

        System.out.println("Patient: " + patient);
        patientRepository.save(patient);
    }
}