package com.saudeall.app.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;


public class Doctor extends Person{
    @Getter
    private int id;
    @Getter
    @Setter
    private String department;
    @Getter
    @Setter
    private String specialization;

    private ArrayList<Location> offices = new ArrayList<>();


    public Doctor(int id,String name, String imageUrl, String department, String specialization, LocalDate dateOfBirth){
        super(name, imageUrl, dateOfBirth);
        this.department = department;
        this.specialization = specialization;

    }

    public Doctor(int id,String name, String imageUrl, LocalDate dateOfBirth){
        super(name, imageUrl, dateOfBirth);

    }

}
