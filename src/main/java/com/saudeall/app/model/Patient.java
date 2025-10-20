package com.saudeall.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "patient")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Patient extends Person {
//    @Id
//    @UuidGenerator
//    private UUID id;

    private String iban;
    @Column(name="contact")
    private String contactDetails;


    public Patient(UUID id,String name, String image, String email, String iban, String contactDetails, LocalDate dateOfBirth){
        super(id, name, image, email, dateOfBirth);
        this.iban = iban;
        this.contactDetails = contactDetails;
    }

    public Patient(UUID id,String name, String image, String email, LocalDate dateOfBirth){
        super(id, name, image, email, dateOfBirth);
    }
}
