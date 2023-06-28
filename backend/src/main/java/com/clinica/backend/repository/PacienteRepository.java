package com.clinica.backend.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinica.backend.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	@Query(value= "SELECT * FROM PACIENTE WHERE CREATED_AT BETWEEN ?1 AND ?2", nativeQuery = true)
	ArrayList<Paciente> findByCreated_at(LocalDateTime start_date, LocalDateTime end_date);
}
