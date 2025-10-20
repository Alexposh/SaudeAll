package com.saudeall.app.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;
    private String image;
    private String email;
    private LocalDate dateOfBirth;
}
