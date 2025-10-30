package com.saudeall.app.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.saudeall.app.model.Doctor;
import com.saudeall.app.model.dto.KeyValueId;
import com.saudeall.app.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public static UUID generateRandomUUID() {
        return UUID.randomUUID();
    }

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getAllByAvailability(LocalDateTime startDate, LocalDateTime endDate) {
        return Collections.emptyList();
    }

    public void add(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Doctor findById(UUID idOfDoctor) {
        return doctorRepository.findById(idOfDoctor);
    }

    public void update(UUID id, Doctor doctor) {
        Doctor doctorToUpdate = doctorRepository.findById(id);

        if (!doctor.getName().isEmpty()) {
            doctorToUpdate.setName(doctor.getName());
        }
        if (!doctor.getImage().isEmpty()) {
            doctorToUpdate.setImage(doctor.getImage());
        }
        if (doctor.getDateOfBirth() != null) {
            doctorToUpdate.setDateOfBirth(doctor.getDateOfBirth());
        }
        if (!doctor.getDepartment().isEmpty()) { // what is the difference to .isBlank() ?
            doctorToUpdate.setDepartment(doctor.getDepartment());
        }
        //if(!doctor.getEmail().isEmpty()){
        //    doctorToUpdate.setEmail(doctor.getEmail());
        //}
        if (!doctor.getSpecialization().isEmpty()) {
            doctorToUpdate.setSpecialization(doctor.getSpecialization());
        }
        doctorRepository.save(doctorToUpdate);
    }

    public void updateOneField(KeyValueId dtoReceived) {
        log.info("update field running");
        doctorRepository.updateField(dtoReceived.getId(), dtoReceived.getValue());
    }

    public List<String> getAllSpecializations() {
        return doctorRepository.getSpecializations();
    }
}
