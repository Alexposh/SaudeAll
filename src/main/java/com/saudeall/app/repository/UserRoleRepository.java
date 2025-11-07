package com.saudeall.app.repository;

import com.saudeall.app.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
    UserRole findById(UUID id);

    List<UserRole> findAllById(UUID id);
}
