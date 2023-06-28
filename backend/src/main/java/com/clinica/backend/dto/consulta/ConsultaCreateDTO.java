package com.clinica.backend.dto.consulta;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.clinica.backend.validation.LocalDateConstraint;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ConsultaCreateDTO {
	
	@NotNull
	@LocalDateConstraint(message = "Insira uma data de consulta válida")
	public String data_consulta;
	@NotBlank
	public String status;
	@NotNull
	public LocalTime horario;
	@NotNull
	public Long paciente_id;
	@NotNull
	public Long recepcionista_id;
	@NotNull
	public Long medico_id;
	
	public LocalDateTime chegada_at;
	public LocalDateTime atendimento_at;
	public String observacao;
	
	public ConsultaCreateDTO(String data_consulta, String status, LocalTime horario, Long paciente_id,
			Long recepcionista_id, Long medico_id, LocalDateTime chegada_at, LocalDateTime atendimento_at,
			String observacao) {
		
		super();
		this.data_consulta = data_consulta;
		this.status = status;
		this.horario = horario;
		this.paciente_id = paciente_id;
		this.recepcionista_id = recepcionista_id;
		this.medico_id = medico_id;
		this.chegada_at = chegada_at;
		this.atendimento_at = atendimento_at;
		this.observacao = observacao;
	}
}
