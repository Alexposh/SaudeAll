package com.saudeall.app.services;

import com.saudeall.app.model.Clinic;
import com.saudeall.app.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClinicService {
    private final ClinicRepository clinicRepository;

    public List<Clinic> getAll(){ return clinicRepository.findAll();}

    public Optional<Clinic> getById(UUID idOfClinic){ return clinicRepository.findById(idOfClinic);}

}
