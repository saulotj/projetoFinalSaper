package com.clinica.backend.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.clinica.backend.dto.planoSaude.PlanoSaudeRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "plano_saude")
public class PlanoSaude {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable = false)
	String nome;
	
	@Column(columnDefinition = "char(1) DEFAULT '0'")
	Boolean is_active;
	
	@CreationTimestamp
	LocalDateTime created_at;

	public PlanoSaude() {};
	
	public PlanoSaude(PlanoSaudeRequestDTO planoDTO) {
		this.nome = planoDTO.getNome();
		this.is_active = planoDTO.getIs_active();
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
