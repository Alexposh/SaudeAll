package com.saudeall.app.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
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

    public void add(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient findById(UUID idOfPatient){
        return patientRepository.findById(idOfPatient);
    }

    public void update(UUID id, Patient patient){
        Patient patientToUpdate = patientRepository.findById(id);

        if(!patient.getName().isEmpty()){
            patientToUpdate.setName(patient.getName());
        }
        if(!patient.getImage().isEmpty()){
            patientToUpdate.setImage(patient.getImage());
        }
        if(patient.getDateOfBirth() != null){
            patientToUpdate.setDateOfBirth(patient.getDateOfBirth());
        }
        if(!patient.getIban().isEmpty()){ // what is the difference to .isBlank() ?
            patientToUpdate.setIban(patient.getIban());
        }
        if(!patient.getContactDetails().isEmpty()){
            patientToUpdate.setContactDetails(patient.getContactDetails());
        }
        if(!patient.getImage().isEmpty()){
            patientToUpdate.setImage(patient.getImage());
        }
        if(!patient.getContactDetails().isEmpty()){
            patientToUpdate.setContactDetails(patient.getContactDetails());
        }

        patientRepository.save(patientToUpdate);
    }

    public void deleteById(UUID id){
        patientRepository.delete(patientRepository.findById(id));
    }


}