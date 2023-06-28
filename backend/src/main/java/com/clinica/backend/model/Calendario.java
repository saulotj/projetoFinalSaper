package com.clinica.backend.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Calendario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	LocalDate data;
	
	@Column(columnDefinition = "char(1) DEFAULT '0'")
	Boolean is_feriado;
	
	@OneToMany(mappedBy = "data")
	Set<Consulta> consulta;
	
	public Calendario() {}
	
	public Calendario(LocalDate data) {
		this.data = data;
	}
	
	public Calendario(LocalDate data, boolean is_feriado) {
		this.data = data;
		this.is_feriado = is_feriado;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(Set<Consulta> consulta) {
		this.consulta = consulta;
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public boolean isIs_feriado() {
		return is_feriado;
	}
	public void setIs_feriado(boolean is_feriado) {
		this.is_feriado = is_feriado;
	}
}
