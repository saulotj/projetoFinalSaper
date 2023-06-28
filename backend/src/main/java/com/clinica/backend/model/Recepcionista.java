package com.clinica.backend.model;

import java.util.Set;
import com.clinica.backend.dto.recepcionista.RecepcionistaRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Recepcionista extends LoggableUser{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "recepcionista")
	private Set<Consulta> consultas;

	public Recepcionista() {}
	
	public Recepcionista(String username, String senha,
			String nome, String email) {
		super(username, senha);
		this.nome = nome;
		this.email = email;
	}

	public Recepcionista(RecepcionistaRequestDTO recepcionistaDTO) {
		super(recepcionistaDTO.username, recepcionistaDTO.senha);
		this.nome = recepcionistaDTO.nome;
		this.email = recepcionistaDTO.email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
}
