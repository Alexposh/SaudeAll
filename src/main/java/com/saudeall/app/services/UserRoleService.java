package com.saudeall.app.services;

import com.saudeall.app.model.UserRole;
import com.saudeall.app.model.enums.Role;
import com.saudeall.app.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleService {
   private final UserRoleRepository userRoleRepository;

   public List<UserRole> getAll(){ return userRoleRepository.findAll();}

   public List<UserRole> getALlProfiles(UUID id){
         return userRoleRepository.findAllById(id);
   }

   public void add(UserRole newUserRole) {
      userRoleRepository.save(newUserRole);
   }
}
