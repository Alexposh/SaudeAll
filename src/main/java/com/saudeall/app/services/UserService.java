package com.saudeall.app.services;

import com.saudeall.app.model.Doctor;
import com.saudeall.app.model.User;
import com.saudeall.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public static UUID generateRandomUUID() {
        return UUID.randomUUID();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(UUID idOfUser){ return userRepository.findById(idOfUser);}

    public User findByEmail(String email){ return userRepository.findByEmail(email);}
}
