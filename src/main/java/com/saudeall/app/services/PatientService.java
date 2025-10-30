package com.saudeall.app.services;

import java.util.List;
import java.util.UUID;

import com.saudeall.app.model.enums.Gender;

import org.springframework.stereotype.Service;
import com.saudeall.app.model.Patient;
import com.saudeall.app.repository.PatientRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    public void update(Patient patient){
        Patient patientToUpdate = patientRepository.findById(patient.getId());

        if(!patient.getFirstName().isEmpty()){
            patientToUpdate.setFirstName(patient.getFirstName());
        }
        if(patient.getImage() != null){
            patientToUpdate.setImage(patient.getImage());
        }
        if(patient.getDateOfBirth() != null){
            log.info(patient.toString());
            patientToUpdate.setDateOfBirth(patient.getDateOfBirth());
        }
        if(!patient.getLastName().isEmpty()){ // what is the difference to .isBlank() ?
            patientToUpdate.setLastName(patient.getLastName());
        }
        if(!patient.getPhoneNumber().isEmpty()){
            patientToUpdate.setPhoneNumber(patient.getPhoneNumber());
        }

        if(patient.getGender().getDisplayName() != null){
//            System.out.println(patient.getGender().getDisplayName());
            patientToUpdate.setGender(Gender.fromDisplayName(patient.getGender().getDisplayName()));
        }

        patientRepository.save(patientToUpdate);

    }

    public void deleteById(UUID id){
        patientRepository.delete(patientRepository.findById(id));
    }


}