package com.clinica.backend.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinica.backend.model.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, LocalDate>{

	Optional<Calendario> findByData(LocalDate data);

	@Query(value= "SELECT * FROM CALENDARIO WHERE data BETWEEN ?1 AND ?2", nativeQuery = true)
	Set<Calendario> findByData(LocalDate date, LocalDate endDate);

}
