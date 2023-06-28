package com.clinica.backend.repository;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.backend.model.Calendario;
import com.clinica.backend.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

	Optional<Consulta> findByHorarioAndData(LocalTime horario, Calendario data);
	
}
