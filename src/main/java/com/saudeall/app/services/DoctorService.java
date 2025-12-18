package com.saudeall.app.services;

import java.time.LocalDateTime;
import java.util.*;

import com.saudeall.app.model.enums.Specialization;
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

    public Optional<Doctor> findById(UUID idOfDoctor) {
        return doctorRepository.findById(idOfDoctor);
    }

    public void update(Doctor doctor) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctor.getId());


        if(optionalDoctor.isEmpty()){
            return;
        }

        Doctor doctorToUpdate = optionalDoctor.get();

        if (!doctor.getFirstName().isEmpty()) {
            doctorToUpdate.setFirstName(doctor.getFirstName());
        }
        if (!doctor.getLastName().isEmpty()) {
            doctorToUpdate.setLastName(doctor.getLastName());
        }
        if (doctor.getImage() != null) {
            doctorToUpdate.setImage(doctor.getImage());
        }
        if (doctor.getEmail() != null) {
            doctorToUpdate.setEmail(doctor.getEmail());
        }
        if (doctor.getGender() != null) {
            doctorToUpdate.setGender(doctor.getGender());
        }
        if(doctor.getDateOfBirth() != null){
            doctorToUpdate.setDateOfBirth(doctor.getDateOfBirth());
        }
        if (doctor.getSpecialization().getDisplayName() != null) {
            doctorToUpdate.setSpecialization(Specialization.fromDisplayName(doctor.getSpecialization().getDisplayName()));
        }
        doctorRepository.save(doctorToUpdate);
    }

}
