package com.saudeall.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name="staff_auth_data")
@NoArgsConstructor
@AllArgsConstructor
public class StaffMember {
    @Id
    @UuidGenerator
    private UUID id;
    private String  email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

}
