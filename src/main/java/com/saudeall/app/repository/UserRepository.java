package com.saudeall.app.repository;

import com.saudeall.app.model.User;
import com.saudeall.app.model.dto.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {


    User findById(UUID id);
    User findByEmail(String email);

}
