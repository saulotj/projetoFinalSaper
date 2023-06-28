package com.clinica.backend.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import com.clinica.backend.dto.consulta.ConsultaCreateDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name = "consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consulta_id")
	Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "data_id")
	Calendario data;
	
	@Column(nullable = false)
	String status;
	
	LocalTime horario;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "recepcionista_id")
	Recepcionista recepcionista;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "medico_id")
	Medico medico;
	
	LocalDateTime chegada_at;
	
	LocalDateTime atendimento_at;
	
	@CreationTimestamp
	LocalDateTime created_at;
	
	String observacao;

	public Consulta() {
	}

	public Consulta(Long id, Calendario data, String tipo_consulta, Paciente paciente,
			Recepcionista recepcionista, Medico medico, LocalDateTime chegada_at, LocalDateTime atendimento_at,
			LocalDateTime created_at, String observacao) {

		this.id = id;
		this.data = data;
		this.status = tipo_consulta;
		this.paciente = paciente;
		this.recepcionista = recepcionista;
		this.medico = medico;
		this.chegada_at = chegada_at;
		this.atendimento_at = atendimento_at;
		this.created_at = created_at;
		this.observacao = observacao;
	}

	public Consulta(ConsultaCreateDTO consultaDTO) {
		super();
		this.status = consultaDTO.status;
		this.horario = consultaDTO.horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendario getData() {
		return data;
	}

	public void setData(Calendario data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Recepcionista getRecepcionista() {
		return recepcionista;
	}

	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public LocalDateTime getChegada_at() {
		return chegada_at;
	}

	public void setChegada_at(LocalDateTime chegada_at) {
		this.chegada_at = chegada_at;
	}

	public LocalDateTime getAtendimento_at() {
		return atendimento_at;
	}

	public void setAtendimento_at(LocalDateTime atendimento_at) {
		this.atendimento_at = atendimento_at;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
