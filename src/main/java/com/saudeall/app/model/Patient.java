package com.saudeall.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Data
@Table(name = "patient")
@EqualsAndHashCode(callSuper = true)
public class Patient extends Person {
    @Id
    private UUID id;

    private String iban;
    @Column(name="contact")
    private String contactDetails;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", picture='" + getImage() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", iban='" + iban + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }
}
