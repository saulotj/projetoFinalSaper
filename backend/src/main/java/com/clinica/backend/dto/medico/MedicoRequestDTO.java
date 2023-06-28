package com.clinica.backend.dto.medico;

import jakarta.validation.constraints.NotBlank;

public class MedicoRequestDTO {
	
	@NotBlank(message = "field username can not be blank")
	public String username;
	@NotBlank(message = "field senha can not be blank")
	public String senha;
	@NotBlank(message = "field name can not be blank")
	public String nome;
	@NotBlank(message = "field email can not be blank")
	public String email;
	@NotBlank(message = "field telefone can not be blank")
	public String telefone;
	@NotBlank(message = "field crm can not be blank")
	public String crm;
	@NotBlank(message = "field especialidade can not be blank")
	public String especialidade;
	
	public MedicoRequestDTO() {
	}

	public MedicoRequestDTO(String nome, String email, String senha, String telefone, String crm,
			String especialidade) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.crm = crm;
		this.especialidade = especialidade;
	}
	
}
