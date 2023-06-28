package com.clinica.backend.model;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.clinica.backend.enums.RoleNames;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Enumerated(EnumType.STRING)
	RoleNames role;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	Set<Recepcionista> recepcionistas;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	Set<Medico> medicos;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	Set<LoggableUser> users;

	@Override
	public String getAuthority() {
		return this.role.toString();
	}
	
}
