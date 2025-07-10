package com.saudeall.app.api;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;
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
        System.out.println("Fetching all patients ...");
        return patientService.getAll();
    }

    @PostMapping(path = "/patient")
    public void createPatient(@RequestBody Patient patient) {
//        Patient patient = new Patient();
//        System.out.println("Create our patient");
//        patient.setName("Frank Doe");
//        patient.setPicture("https://example.com/picture.jpg");
//        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));
//        patient.setIban("DE89370400440532013000");
//        patient.setContactDetails("john.doe@company.com");
//        System.out.println("Patient: " + patient);
        System.out.println("Adding a patient....");
        patientService.add(patient);
    }
    @GetMapping(path="/patient/{id}")
    public Patient getSinglePatient(@PathVariable UUID id){
        return patientService.findById(id);

    }

    @PutMapping(path="/patient-update/{id}")
    public void updatePatient(@PathVariable UUID id, @RequestBody Patient updatedPatient){
        patientService.update(id, updatedPatient);
    }

    @DeleteMapping(path=("/patient-delete/{id}"))
    public void deletePatient(@PathVariable UUID id){
        patientService.deleteById(id);
    }
}
