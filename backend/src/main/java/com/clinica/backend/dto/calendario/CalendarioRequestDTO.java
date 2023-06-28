package com.clinica.backend.dto.calendario;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class CalendarioRequestDTO {
	@NotNull(message = "field dataInicial can not be null")
	LocalDate dataInicial;
	
	@NotNull(message = "field dataFinal can not be null")
	LocalDate dataFinal;
			
	public CalendarioRequestDTO() {}
	
	public CalendarioRequestDTO(LocalDate dataInicial, LocalDate dataFinal) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
}
