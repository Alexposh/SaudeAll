package com.saudeall.app.services;

import com.saudeall.app.model.Role;
import com.saudeall.app.model.StaffMember;
import com.saudeall.app.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;

    public List<StaffMember> getAll(){
        return staffRepository.findAll();
    }

    public void add(StaffMember staffMember){
        staffRepository.save(staffMember);
    }

    public StaffMember findById(UUID idOfStaffMember){
        return staffRepository.findById(idOfStaffMember);
    }

    public StaffMember findByEmail(String emailOfStaffMember){
        return staffRepository.findByEmail(emailOfStaffMember);
    }

    public List<StaffMember> findByRole(String roleEntered){
        Role roleEnteredToFilter = Role.fromRoleName(roleEntered);
        return staffRepository.findByRole(roleEnteredToFilter);
    }
}
