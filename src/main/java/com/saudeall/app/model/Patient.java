package com.saudeall.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "patient")
@EqualsAndHashCode(callSuper = true)
public class Patient extends Person {
    @Id
    @UuidGenerator
    private UUID id;

    private String iban;
    @Column(name="contact")
    private String contactDetails;


    public Patient(int id,String name, String image, String email, String iban, String contactDetails, LocalDate dateOfBirth){
        super(name, image, email, dateOfBirth);
        this.iban = iban;
        this.contactDetails = contactDetails;

    }
//    @Override
//    public String toString() {
//        return "Patient{" +
//                "id=" + id +
//                ", name='" + getName() + '\'' +
//                ", picture='" + getImage() + '\'' +
//                ", dateOfBirth=" + getDateOfBirth() +
//                ", iban='" + iban + '\'' +
//                ", contactDetails='" + contactDetails + '\'' +
//                '}';
//    }
}
