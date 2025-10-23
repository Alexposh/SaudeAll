package com.saudeall.app.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

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
