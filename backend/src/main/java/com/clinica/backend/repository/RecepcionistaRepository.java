package com.clinica.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.backend.model.Recepcionista;

@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Long>{

	Optional<Recepcionista> findByNome(String nome);

	Optional<Recepcionista> findByUsername(String username);

}
