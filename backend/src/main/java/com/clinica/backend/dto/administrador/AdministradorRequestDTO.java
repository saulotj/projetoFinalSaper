package com.clinica.backend.dto.administrador;

public class AdministradorRequestDTO {
	public String username;
	public String senha;
	public String teste;
	
	public AdministradorRequestDTO() {
		super();
	}

	public AdministradorRequestDTO(String username, String senha, String teste) {
		super();
		this.username = username;
		this.senha = senha;
		this.teste = teste;
	}
}
