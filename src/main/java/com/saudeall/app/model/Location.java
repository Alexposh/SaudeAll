package com.saudeall.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Table(name="location")
public class Location {
    @Id
    private UUID id;
    private String name;
    private String city;
    private String street;
    private int number;
    private int numberExtension;
    private String country;
    private String zipCode;
}
