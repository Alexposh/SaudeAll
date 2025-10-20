package com.saudeall.app.repository;

import com.saudeall.app.model.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findById(UUID idOfDoctor);

//    @Transactional
//    @Query(value = "update doctor set image=:value where id=:id", nativeQuery = true)
//    void updateField(@Param("id")UUID id, @Param("value")String value);


    @Modifying
    @Transactional
    @Query(value = "UPDATE doctor SET image = :value WHERE id = :id", nativeQuery = true)
    void updateField(@Param("id") UUID id, @Param("value") String value);


    @Query(value = "SELECT DISTINCT d.specialization FROM Doctor d")
    ArrayList<String> getSpecializations();

}