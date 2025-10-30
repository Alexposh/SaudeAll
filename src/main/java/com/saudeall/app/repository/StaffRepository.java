package com.saudeall.app.repository;

import com.saudeall.app.model.Role;
import com.saudeall.app.model.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<StaffMember, Long> {
    StaffMember findById(UUID idOfStaffMember);

    StaffMember findByEmail(String email);

    List<StaffMember> findByRole(Role role);
}
