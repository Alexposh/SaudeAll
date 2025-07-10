package com.saudeall.app.repository;

import com.saudeall.app.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    Appointment findById(UUID idOfAppointment);

}
