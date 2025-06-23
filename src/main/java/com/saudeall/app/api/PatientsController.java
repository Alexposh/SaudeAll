package com.saudeall.app.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saudeall.app.model.Patient;
import com.saudeall.app.services.PatientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patients")
public class PatientsController {
    private final PatientService patientService;

    @GetMapping
    public List<Patient> getPatients() {
        System.out.println("Fetching all patients 1...");
        return patientService.getAll();
    }

    @PostMapping("/patient")
    public void createPatient() {
        patientService.add();
    }
}
