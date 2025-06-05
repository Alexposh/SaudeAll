package com.saudeall.app.api;

import com.saudeall.app.model.Patient;
import com.saudeall.app.services.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class PatientsController {
    private final PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientService.getAll();
    }
}
