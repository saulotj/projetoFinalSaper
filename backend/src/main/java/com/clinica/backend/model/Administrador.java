package com.clinica.backend.model;

import java.util.Set;

import com.clinica.backend.dto.administrador.AdministradorRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "administrador_id")
public class Administrador extends LoggableUser{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Administrador() {
		super();
	}
	
	public Administrador(String username, String senha) {
		super(username, senha);
	}

	public Administrador(AdministradorRequestDTO admDTO) {
		super(admDTO.username, admDTO.senha);
	}
	
	public void setRoles(Set<Role> roles) {
		super.setRoles(roles);
	}

}
