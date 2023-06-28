package com.clinica.backend.dto.consulta;

import java.time.LocalDate;
import java.time.LocalTime;

import com.clinica.backend.enums.URL;
import com.clinica.backend.model.Consulta;

public class ConsultaSmallResponseDTO {
	private Long id;
	private LocalDate data;
	private LocalTime horario;
	private String status;
	private String url;
	
	public ConsultaSmallResponseDTO(Consulta consulta) {
		this.id = consulta.getId();
		this.data = consulta.getData().getData();
		this.status = consulta.getStatus();
		this.horario = consulta.getHorario();
		generateUrl();
	}
	
	private void generateUrl() {
		this.url = URL.CONSULTA.getUrl() + this.id;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
