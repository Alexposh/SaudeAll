package com.saudeall.app.api;

import com.saudeall.app.model.Patient;
import com.saudeall.app.model.User;
import com.saudeall.app.model.dto.LoginData;
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

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping(path="/create")
    public Patient createUser(@RequestBody User user){

        userService.add(user); // this created the user in the patient_auth_data table
        User newUserCreated = userService.findByEmail(user.getEmail());
        Patient newPatientToBeCreated = new Patient();
        newPatientToBeCreated.setId(newUserCreated.getId());
        newPatientToBeCreated.setEmail(newUserCreated.getEmail());
        patientService.add(newPatientToBeCreated); // here we should add a patient in the patient table
//        System.out.println(userService.findByEmail(user.getEmail()));
        return patientService.findById(newPatientToBeCreated.getId());
    }

    @PostMapping(path = "/login")
    public User FindUserByName(@RequestBody LoginData loginData){
        User userFound = userService.findByEmail(loginData.getEmail());
        System.out.println(userFound.getEmail());
        System.out.println(userFound.getPassword());
         System.out.println(userFound.getId());
        return userFound;
    }
}
