package com.saudeall.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name="location")
public class Location {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private String street;
    private int street_number;
    private int number_extension;
    private String country;
    private String zip_code;
    private String city;


}
