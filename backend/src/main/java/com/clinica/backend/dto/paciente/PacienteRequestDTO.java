package com.clinica.backend.dto.paciente;

import java.time.LocalDate;

import com.clinica.backend.model.Paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PacienteRequestDTO {
	@NotBlank(message = "field nome can not be blank")
	@Size(min = 5, max = 10, message = "field nome must be at least 3 and max 10 characters")
	public String nome;
	
	public String responsavel;
	
	@NotBlank(message = "field cpf can not be blank")
	@Pattern(regexp = "[\\d]{11}", message = "field cpf is invalid")
	public String cpf;
	
	@Email(message = "field email is invalid")
	public String email;
	
	@NotBlank(message = "field endereco can not be blank")
	@Size(min = 2, max = 60, message = "Seu endereço não atende os requisitos de tamanho (entre 3 e 60)")
	public String endereco;
	
	@NotBlank(message = "field telefone can not be blank")
	public 	String telefone;
	
	@NotNull(message = "field dt_nascimento can not be blank")
	public LocalDate dt_nascimento;
	
	public PacienteRequestDTO() {
	}
	
	public PacienteRequestDTO(Paciente paciente) {
		this.nome = paciente.getNome();
		this.responsavel = paciente.getResponsavel();
		this.cpf = paciente.getCpf();
		this.email = paciente.getEmail();
		this.endereco = paciente.getEndereco();
		this.telefone = paciente.getTelefone();
	}
}
