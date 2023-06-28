package com.clinica.backend.dto.consulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.clinica.backend.model.Consulta;

public class ConsultaResponseDTO {
	private Long id;
	private LocalDate data;
	private LocalTime horario;
	private String status;
	private Long paciente_id;
	private Long recepcionista_id;
	private Long medico_id;
	private LocalDateTime chegada_at;
	private LocalDateTime atendimento_at;
	private LocalDateTime created_at;
	private String observacao;
	
	public ConsultaResponseDTO(Consulta consulta) {
		this.id = consulta.getId();
		this.data = consulta.getData().getData();
		this.status = consulta.getStatus();
		this.paciente_id = consulta.getPaciente().getId();
		this.recepcionista_id = consulta.getRecepcionista().getId();
		this.medico_id = consulta.getMedico().getId();
		this.chegada_at = consulta.getChegada_at();
		this.atendimento_at = consulta.getAtendimento_at();
		this.created_at = consulta.getCreated_at();
		this.observacao = consulta.getObservacao();
		this.horario = consulta.getHorario();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(Long paciente_id) {
		this.paciente_id = paciente_id;
	}

	public Long getRecepcionista_id() {
		return recepcionista_id;
	}

	public void setRecepcionista_id(Long recepcionista_id) {
		this.recepcionista_id = recepcionista_id;
	}

	public Long getMedico_id() {
		return medico_id;
	}

	public void setMedico_id(Long medico_id) {
		this.medico_id = medico_id;
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
