package com.saudeall.app.model;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String picture;
    private LocalDate dateOfBirth;
}
