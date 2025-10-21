package com.saudeall.app.repository;

import com.saudeall.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findById(UUID id);

}
