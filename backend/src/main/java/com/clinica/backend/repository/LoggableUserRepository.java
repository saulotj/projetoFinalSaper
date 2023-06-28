package com.clinica.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.backend.model.LoggableUser;

@Repository
public interface LoggableUserRepository extends JpaRepository<LoggableUser, Long> {
	Optional<LoggableUser> findByUsername(String username);
}
