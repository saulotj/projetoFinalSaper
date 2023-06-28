package com.clinica.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.backend.enums.RoleNames;
import com.clinica.backend.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByRole(RoleNames role);
}
