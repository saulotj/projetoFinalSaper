package com.clinica.backend.dto.recepcionista;

import jakarta.validation.constraints.NotBlank;

public class RecepcionistaRequestDTO {
	@NotBlank(message = "field username can not be blank")
	public String username;
	
	@NotBlank(message = "field nome can not be blank")
	public String nome;
	
	@NotBlank(message = "field email can not be blank")
	public String email;
	
	@NotBlank(message = "field senha can not be blank")
	public String senha;
	
	public RecepcionistaRequestDTO() {
	}

	public RecepcionistaRequestDTO(String username, String nome, String email, String senha) {
		super();
		this.username = username;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
	}
}
