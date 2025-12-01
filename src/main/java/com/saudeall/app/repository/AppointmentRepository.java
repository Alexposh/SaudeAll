package com.saudeall.app.repository;

import com.saudeall.app.model.Appointment;
import com.saudeall.app.model.dto.AppointmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    Appointment findById(UUID idOfAppointment);

    List<Appointment> findByPatientId(UUID patientId);





    @Query(value = """
                   SELECT appointment.id, doctor.first_name, doctor.last_name, doctor.image, appointment.status as appointment_status, appointment.date_of_appointment, clinic.name as location_name
                   FROM appointment
                        JOIN doctor ON doctor.id = appointment.doctor_id
                        JOIN clinic ON appointment.location_id = clinic.id
                   WHERE
                     appointment.patient_id = :patientId
                   """, nativeQuery = true)
    List<Appointment> findPatientAppointmentsWithDetails(@Param("patientId") UUID patientId);

}
