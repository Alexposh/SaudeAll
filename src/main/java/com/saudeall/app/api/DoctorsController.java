package com.saudeall.app.api;
import com.saudeall.app.model.DTO.AvailabilityDTO;
import com.saudeall.app.services.DoctorService;

import com.saudeall.app.model.Doctor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class DoctorsController {
    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorService.getAll();
    }

    @GetMapping("/doctors/date")
    public List<Doctor> getDoctorsByAvailabilty(@RequestBody AvailabilityDTO availabiltyDTO){
        return doctorService.getAllByAvailability(availabiltyDTO.getStartDate(), availabiltyDTO.getEndDate());

    }


}
