package com.saudeall.app.api;

import com.saudeall.app.model.User;
import com.saudeall.app.model.dto.LoginData;
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

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping(path="/create")
    public void createUser(@RequestBody User user){
        userService.add(user);
    }

    @PostMapping(path = "/login")
    public User FindUserByName(@RequestBody LoginData loginData){
        User userFound = userService.findByEmail(loginData.getEmail());
        System.out.println(userFound.getEmail());
        System.out.println(userFound.getPassword());
        System.out.println(userFound.getRole_id());
        System.out.println(userFound.getId());
        if(userFound.getRole_id().toString().equals("55558400-e29b-41d4-a716-446655440010")){
            System.out.println("login data entered is for a patient");
        }
        if(userFound.getRole_id().toString().equals("33338400-e29b-41d4-a716-446655440010")){
            System.out.println("login data entered is for a doctor");
        }

        if(userFound.getRole_id().toString().equals("11118400-e29b-41d4-a716-446655440010")){
            System.out.println("login data entered is for an admin");
        }

        return userFound;
    }
}
