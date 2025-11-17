package com.saudeall.app.repository;

import com.saudeall.app.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    Appointment findById(UUID idOfAppointment);

    List<Appointment> findByPatientId(UUID patientId);


}
