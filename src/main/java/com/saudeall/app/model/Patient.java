package com.saudeall.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "patients")
@EqualsAndHashCode(callSuper = true)
public class Patient extends Person {
    @Id
    private int id;

    private String iban;
    private String contactDetails;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", picture='" + getPicture() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", iban='" + iban + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }
}
