package com.saudeall.app.api;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.saudeall.app.model.Gender;
import com.saudeall.app.model.User;
import com.saudeall.app.model.dto.GenderDTO;
import com.saudeall.app.model.dto.LoginData;
import com.saudeall.app.services.UserService;
import org.springframework.web.bind.annotation.*;
import com.saudeall.app.model.Patient;
import com.saudeall.app.services.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patients")
@CrossOrigin(origins="http://localhost:8100")
public class PatientsController {
    private final PatientService patientService;

    @GetMapping
    public List<Patient> getPatients() {
        System.out.println("Fetching all patients ...");
        return patientService.getAll();
    }

    @GetMapping("/genders")
    public List<GenderDTO> getGenders() {
        return Arrays.stream(Gender.values())
                .map(gender -> new GenderDTO(gender.name(), gender.getDisplayName()))
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/patient")
    public void createPatient(@RequestBody Patient patient) {
        System.out.println("Adding a patient....");
        patientService.add(patient);
    }

    @GetMapping(path="/patient/{id}")
    public Patient getSinglePatient(@PathVariable UUID id){ return patientService.findById(id);}



    @PutMapping(path="/patient-update")
    public Patient updatePatient(@RequestBody Patient updatedPatient){
        patientService.update(updatedPatient);
        return patientService.findById(updatedPatient.getId());
    }

    @DeleteMapping(path=("/patient-delete/{id}"))
    public void deletePatient(@PathVariable UUID id){
        patientService.deleteById(id);
    }
}
