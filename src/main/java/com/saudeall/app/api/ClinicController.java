package com.saudeall.app.api;

import com.saudeall.app.model.Clinic;
import com.saudeall.app.services.ClinicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:8100")
@RequestMapping("api/v1/clinics")
public class ClinicController {
    private final ClinicService clinicService;

    @GetMapping
    public List<Clinic> getAllClinics(){
        return clinicService.getAll();
    }

}
