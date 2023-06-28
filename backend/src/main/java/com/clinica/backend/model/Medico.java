package com.clinica.backend.model;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.clinica.backend.dto.medico.MedicoRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Medico extends LoggableUser implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	String nome;
	
	@Column(nullable = false)
	String email;

	@Column(nullable = false)
	String telefone;
	
	@Column(nullable = false)
	String crm;
	
	@Column(nullable = false)
	String especialidade;
	
	@OneToMany(mappedBy = "medico")
	Set<Consulta> consulta;

	public Medico() {};

	public Medico(
			String username, String senha, String nome,
			String email, String telefone, String crm,
			String especialidade) {
		super(username, senha);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public Medico(MedicoRequestDTO medicoDTO) {
		super(medicoDTO.username, medicoDTO.senha);
		this.nome = medicoDTO.nome;
		this.email = medicoDTO.email;
		this.telefone = medicoDTO.telefone;
		this.crm = medicoDTO.crm;
		this.especialidade = medicoDTO.especialidade;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public Set<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(Set<Consulta> consulta) {
		this.consulta = consulta;
	}

}
