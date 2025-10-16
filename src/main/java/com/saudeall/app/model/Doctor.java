package com.saudeall.app.model;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Data
@Table(name="doctor")
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class Doctor extends Person{
    @Id
    @UuidGenerator
    private UUID id;

    private String department;

    private String specialization;

//    private ArrayList<Location> offices = new ArrayList<>();

    public Doctor(int id,String name, String image, String email, String department, String specialization, LocalDate dateOfBirth){
        super(name, image, email, dateOfBirth);
        this.department = department;
        this.specialization = specialization;

    }

    public Doctor(int id,String name, String image, String email, LocalDate dateOfBirth){
        super(name, image, email, dateOfBirth);
    }

}
