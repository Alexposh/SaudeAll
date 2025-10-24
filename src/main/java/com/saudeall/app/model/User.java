package com.saudeall.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name="app_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @UuidGenerator
    private UUID id;

    private String email;
    private String password;
    private UUID role_id;



}
