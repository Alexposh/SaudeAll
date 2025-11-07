package com.saudeall.app.api;
import com.saudeall.app.model.dto.AvailabilityDTO;
import com.saudeall.app.model.dto.KeyValueId;
import com.saudeall.app.services.DoctorService;
import com.saudeall.app.model.Doctor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:8100")
@RequestMapping("/api/v1/doctors")
public class DoctorsController {
    private final DoctorService doctorService;

    @GetMapping
    public List<Doctor> getDoctors(){
        System.out.println("Fetching all doctors");
        return doctorService.getAll();
    }

//    @PostMapping(path="/create")
//    public void createDoctor(@RequestBody Doctor doctor) {
//        System.out.println("Adding a doctor...");
//        doctorService.add(doctor);
//    }

    @PostMapping(path="/create")
    public void createDoctor(@RequestBody Doctor doctor) {
        System.out.println("Adding a doctor...");
        doctorService.add(doctor);
    }

    @GetMapping("/doctor/{id}")
    public Doctor getSingleDoctor(@PathVariable UUID id){
        return doctorService.findById(id);
    }

    @PutMapping(path="/doctor-update")
    public Doctor updateDoctor(@RequestBody Doctor updatedDoctor){
        System.out.println(updatedDoctor);
        doctorService.update(updatedDoctor);
        return doctorService.findById(updatedDoctor.getId());
    }

    @GetMapping("/doctors/date")
    public List<Doctor> getDoctorsByAvailability(@RequestBody AvailabilityDTO availabilityDTO){
        return doctorService.getAllByAvailability(availabilityDTO.getStartDate(), availabilityDTO.getEndDate());

    }

}
