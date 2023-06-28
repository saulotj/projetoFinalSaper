package com.clinica.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.backend.model.PlanoSaude;

@Repository
public interface PlanoSaudeRepository extends JpaRepository<PlanoSaude, Long> {
	
}
