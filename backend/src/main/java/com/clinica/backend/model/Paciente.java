package com.clinica.backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.clinica.backend.dto.paciente.PacienteRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paciente_id")
	Long id;
	
	@Column(nullable = false)
	String nome;

	@Column(nullable = true)
	String responsavel;
	
	@Column(nullable = false)
	String cpf;
	
	@Column(nullable = false)
	String email;
	
	String endereco;
	
	@Column(nullable = false)
	String telefone;
	
	@Column(nullable = false)
	LocalDate dt_nascimento;
	
	@CreationTimestamp
	LocalDateTime created_at;
	
	@OneToMany(mappedBy = "paciente")
	Set<Consulta> consulta;
	
	public Paciente() {
	}
	
	public Paciente(PacienteRequestDTO pacienteDTO) {
		this.nome = pacienteDTO.nome;
		this.responsavel = pacienteDTO.responsavel;
		this.cpf = pacienteDTO.cpf;
		this.email = pacienteDTO.email;
		this.endereco = pacienteDTO.endereco;
		this.telefone = pacienteDTO.telefone;
		this.dt_nascimento = pacienteDTO.dt_nascimento;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
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

	public LocalDateTime getCreated_at() {
		return this.created_at;
	}

	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public Set<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(Set<Consulta> consulta) {
		this.consulta = consulta;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
