package com.saudeall.app.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.saudeall.app.model.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "patient")
//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
//    @Id
//    @UuidGenerator
//    private UUID id;

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String image;
    private String phoneNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
//    private String iban;
//    @Column(name="contact")
//    private String contactDetails;

//    public Patient(UUID id,String name, String image, String email, String iban, String contactDetails, LocalDate dateOfBirth){
//        super(id, name, image, email, dateOfBirth);
//        this.iban = iban;
//        this.contactDetails = contactDetails;
//    }
//
//    public Patient(UUID id,String name, String image, String email, LocalDate dateOfBirth){
//        super(id, name, image, email, dateOfBirth);
//    }

    public Patient(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

}
