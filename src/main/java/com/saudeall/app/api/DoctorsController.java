package com.saudeall.app.api;
import com.saudeall.app.model.DTO.AvailabilityDTO;
import com.saudeall.app.services.DoctorService;
import com.saudeall.app.model.Doctor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctors")
public class DoctorsController {
    private final DoctorService doctorService;

    @GetMapping
    public List<Doctor> getDoctors(){
        return doctorService.getAll();
    }

    @GetMapping("/doctor/{id}")
    public Doctor getSingleDoctor(@PathVariable UUID id){
        return doctorService.findById(id);
    }

    @GetMapping("/doctors/date")
    public List<Doctor> getDoctorsByAvailability(@RequestBody AvailabilityDTO availabilityDTO){
        return doctorService.getAllByAvailability(availabilityDTO.getStartDate(), availabilityDTO.getEndDate());

    }

    @PostMapping(path="/doctor")
    public void createDoctor(@RequestBody Doctor doctor) {
        System.out.println("Adding a doctor...");
        doctorService.add(doctor);
    }


}
