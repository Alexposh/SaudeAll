package com.saudeall.app.api;

import com.saudeall.app.model.Doctor;
import com.saudeall.app.model.Patient;
import com.saudeall.app.model.User;
import com.saudeall.app.model.dto.LoginData;
import com.saudeall.app.services.DoctorService;
import com.saudeall.app.services.PatientService;
import com.saudeall.app.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@CrossOrigin(origins="http://localhost:8100")
public class UserController {
    private final UserService userService;
    private  final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping(path="/create-patient")
    public Patient createUser(@RequestBody User user){
        userService.add(user);
        User newUserCreated = userService.findByEmail(user.getEmail());
        Patient newPatientToBeCreated = new Patient(newUserCreated.getId(), newUserCreated.getEmail());
        patientService.add(newPatientToBeCreated);
        return patientService.findById(newPatientToBeCreated.getId());
    }

    @PostMapping(path="/create-doctor")
    public Doctor createDoctor(@RequestBody User newDoctor){
        userService.add(newDoctor);
        User newDoctorCreated = userService.findByEmail(newDoctor.getEmail());
        Doctor newlyDoctorCreated = new Doctor(newDoctorCreated.getId(),newDoctorCreated.getEmail());
        doctorService.add(newlyDoctorCreated);
        return doctorService.findById(newDoctorCreated.getId());
    }

    @PostMapping(path = "/login")
    public User findUserByName(@RequestBody LoginData loginData){
        User userFound = userService.findByEmail(loginData.getEmail());
        log.info(userFound.getEmail());
        log.info(userFound.getPassword());
        log.info(userFound.getId().toString());
        log.info(userFound.toString());
        return userFound;
    }

}
