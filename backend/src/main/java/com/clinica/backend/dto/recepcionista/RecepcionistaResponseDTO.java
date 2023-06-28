package com.clinica.backend.dto.recepcionista;

import java.time.LocalDateTime;

import com.clinica.backend.model.Recepcionista;

public class RecepcionistaResponseDTO {
	Long id;
	String nome;
	String username;
	String email;
	LocalDateTime created_at;
	
	public RecepcionistaResponseDTO() {
	}
	
	public RecepcionistaResponseDTO(Recepcionista recepcionista) {
		this.id = recepcionista.getId();
		this.nome = recepcionista.getNome();
		this.username = recepcionista.getUsername();
		this.email = recepcionista.getEmail();
		this.created_at = recepcionista.getCreated_at();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
