package com.saudeall.app.model;

import com.saudeall.app.model.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name="user_role")
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    public UUID id;
    public String name;

//    public UserRole(UUID id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
