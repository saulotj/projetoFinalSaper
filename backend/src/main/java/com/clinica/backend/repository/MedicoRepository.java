package com.clinica.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.backend.model.Medico;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
	Optional<Medico> findByUsername(String username);
}
