package com.clinica.backend.dto.administrador;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.clinica.backend.model.Administrador;
import com.clinica.backend.model.Role;

public class AdministradorResponseDTO {
	public Long id;
	public String username;
	public Collection<? extends GrantedAuthority> roles;
	
	public AdministradorResponseDTO() {
		super();
	}

	public AdministradorResponseDTO(Long id, String username, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
	
	public AdministradorResponseDTO(Administrador adm) {
		this.id = adm.getId();
		this.username = adm.getUsername();
		this.roles = adm.getAuthorities();
	}
	
}
