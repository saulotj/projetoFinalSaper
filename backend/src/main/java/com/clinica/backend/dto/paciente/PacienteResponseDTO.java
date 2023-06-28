package com.clinica.backend.dto.paciente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.clinica.backend.dto.consulta.ConsultaSmallResponseDTO;
import com.clinica.backend.model.Paciente;

public class PacienteResponseDTO {
	Long paciente_id;
	String nome;
	String cpf;
	String email;
	String endereco;
	String telefone;
	LocalDateTime created_at;
	List<ConsultaSmallResponseDTO> consulta;
	
	public PacienteResponseDTO(Paciente paciente) {
		this.paciente_id = paciente.getId();
		this.nome = paciente.getNome();
		this.cpf = paciente.getCpf();
		this.email = paciente.getEmail();
		this.endereco = paciente.getEndereco();
		this.telefone = paciente.getTelefone();
		this.created_at = paciente.getCreated_at();
		this.consulta =
				(paciente.getConsulta() != null)?
						paciente.getConsulta().stream().map(consulta -> new ConsultaSmallResponseDTO(consulta)).toList()
					:
						new ArrayList<ConsultaSmallResponseDTO>();
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}


	public Long getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(Long paciente_id) {
		this.paciente_id = paciente_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<ConsultaSmallResponseDTO> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<ConsultaSmallResponseDTO> consulta) {
		this.consulta = consulta;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
}
