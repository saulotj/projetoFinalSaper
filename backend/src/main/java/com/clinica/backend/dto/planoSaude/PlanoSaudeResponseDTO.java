package com.clinica.backend.dto.planoSaude;

import java.time.LocalDateTime;

import com.clinica.backend.model.PlanoSaude;

public class PlanoSaudeResponseDTO {
	Long id;
	String nome;
	Boolean is_active;
	LocalDateTime created_at;
	
	public PlanoSaudeResponseDTO() {}
	
	public PlanoSaudeResponseDTO(PlanoSaude plano) {
		this.id = plano.getId();
		this.nome = plano.getNome();
		this.is_active = plano.getIs_active();
		this.created_at = plano.getCreated_at();
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

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
}
