package com.saudeall.app.services;

import com.saudeall.app.model.Appointment;
import com.saudeall.app.model.Doctor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
    public List<Appointment> getAll(){
        return null;
    }

    public List<Appointment> getAllByDate(LocalDateTime date){
        return null;
    }

    public List<Appointment> getAllByDoctor(UUID doctorId){
        return null;
    }

    public List<Appointment> getAllByDoctorAndDate(UUID doctorId, LocalDateTime date){
        return null;
    }

    public List<Appointment> getAllByDoctorAndStatus(UUID doctorId, Boolean status){
        return null;
    }

}
