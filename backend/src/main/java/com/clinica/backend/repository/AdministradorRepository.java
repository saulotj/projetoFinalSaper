package com.clinica.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.backend.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{

	Optional<Administrador> findByUsername(String username);

}
