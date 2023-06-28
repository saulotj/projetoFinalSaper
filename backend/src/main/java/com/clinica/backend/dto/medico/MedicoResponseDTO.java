package com.clinica.backend.dto.medico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.clinica.backend.dto.consulta.ConsultaSmallResponseDTO;
import com.clinica.backend.model.Medico;

public class MedicoResponseDTO {
	
	Long id;
	String nome;
	String username;
	String email;
	String crm;
	String telefone;
	String especialidade;
	LocalDateTime created_at;
	Collection<? extends GrantedAuthority> role;
	List<ConsultaSmallResponseDTO> consultas;
	
	public MedicoResponseDTO(Medico medico) {
		this.id = medico.getId();
		this.nome = medico.getNome();
		this.username = medico.getUsername();
		this.email = medico.getEmail();
		this.crm = medico.getCrm();
		this.telefone = medico.getTelefone();
		this.especialidade = medico.getEspecialidade();
		this.created_at = medico.getCreated_at();
		this.role = medico.getAuthorities();
		this.consultas =
				(medico.getConsulta() != null)?
							medico.getConsulta().stream().map(consulta -> new ConsultaSmallResponseDTO(consulta)).toList()
						:
							new ArrayList<ConsultaSmallResponseDTO>();
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
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public List<ConsultaSmallResponseDTO> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaSmallResponseDTO> consultas) {
		this.consultas = consultas;
	}
	
	public Collection<? extends GrantedAuthority> getRole() {
		return role;
	}

}
