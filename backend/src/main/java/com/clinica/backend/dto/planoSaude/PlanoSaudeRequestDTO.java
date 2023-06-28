package com.clinica.backend.dto.planoSaude;

public class PlanoSaudeRequestDTO {
	String nome;
	Boolean is_active;
	
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
}
