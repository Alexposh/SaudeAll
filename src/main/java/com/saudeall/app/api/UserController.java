package com.saudeall.app.api;

import com.saudeall.app.model.Doctor;
import com.saudeall.app.model.Patient;
import com.saudeall.app.model.User;
import com.saudeall.app.model.UserRole;
import com.saudeall.app.model.dto.LoginData;
import com.saudeall.app.model.enums.Role;
import com.saudeall.app.services.DoctorService;
import com.saudeall.app.services.PatientService;
import com.saudeall.app.services.UserRoleService;
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
    private final UserRoleService userRoleService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping(path="create-user")
    public User createNewUser(@RequestBody User user){
        userService.add(user);
        User newUserCreated = userService.findByEmail(user.getEmail());
        UserRole newUserRole = new UserRole(newUserCreated.getId(),user.getRole());
        userRoleService.add(newUserRole);
            if(user.getRole().equals("patient")){
                Patient newPatientToBeCreated = new Patient(newUserCreated.getId(), newUserCreated.getEmail());
                patientService.add(newPatientToBeCreated);
            }

            if(user.getRole().equals("doctor")){
                Doctor newDoctorToBeCreated = new Doctor(newUserCreated.getId(), newUserCreated.getEmail());
                doctorService.add(newDoctorToBeCreated);
            }
        return userService.findByEmail(user.getEmail());
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
        String role = Role.DOCTOR.getRoleName();
        userService.add(newDoctor);
        User newDoctorCreated = userService.findByEmail(newDoctor.getEmail());
        UserRole newUserRole = new UserRole(newDoctor.getId(),role);
        userRoleService.add(newUserRole);
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
    @PostMapping(path = "/login-doctor")
    public User findDoctorByName(@RequestBody LoginData loginData){
        return userService.findByEmail(loginData.getEmail());
//        log.info(userFound.getEmail());
//        log.info(userFound.getPassword());
//        log.info(userFound.getId().toString());
//        log.info(userFound.toString());
//        return userFound;
    }

}
