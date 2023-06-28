package com.clinica.backend.dto.calendario;

import java.time.LocalDate;
import java.util.List;

import com.clinica.backend.dto.consulta.ConsultaSmallResponseDTO;
import com.clinica.backend.model.Calendario;

public class CalendarioResponseDTO {
	LocalDate data;
	List<ConsultaSmallResponseDTO> consulta;
	
	public CalendarioResponseDTO() {}
	public CalendarioResponseDTO(Calendario data ) {
		this.data = data.getData();
		this.consulta = data.getConsulta().stream().map(consulta -> new ConsultaSmallResponseDTO(consulta)).toList();
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public List<ConsultaSmallResponseDTO> getConsulta() {
		return consulta;
	}
	public void setConsulta(List<ConsultaSmallResponseDTO> consulta) {
		this.consulta = consulta;
	}
}
