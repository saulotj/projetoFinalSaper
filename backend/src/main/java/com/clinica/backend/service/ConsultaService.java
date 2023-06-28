package com.clinica.backend.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clinica.backend.dto.consulta.ConsultaCreateDTO;
import com.clinica.backend.dto.consulta.ConsultaResponseDTO;
import com.clinica.backend.dto.consulta.ConsultaSmallResponseDTO;
import com.clinica.backend.exception.ResourceNotFoundException;
import com.clinica.backend.model.Calendario;
import com.clinica.backend.model.Consulta;
import com.clinica.backend.model.Medico;
import com.clinica.backend.model.Paciente;
import com.clinica.backend.model.Recepcionista;
import com.clinica.backend.repository.CalendarioRepository;
import com.clinica.backend.repository.ConsultaRepository;
import com.clinica.backend.repository.MedicoRepository;
import com.clinica.backend.repository.PacienteRepository;
import com.clinica.backend.repository.RecepcionistaRepository;
import com.clinica.backend.util.ObjectProperties;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ConsultaService {
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	RecepcionistaRepository recepcionistaRepository;
	
	@Autowired
	MedicoRepository medicoRepository;
	
	@Autowired
	CalendarioRepository calendarioRepository;
	
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findAll().stream().map(consulta -> new ConsultaSmallResponseDTO(consulta)));
	}

	@Transactional
	public ResponseEntity<Object> update(Long id, Consulta consultaDTO) {
		Consulta consulta = consultaRepository.findById(id).orElseThrow();
		ObjectProperties.myCopyProperties(consultaDTO, consulta);
		consultaRepository.save(consulta);
		return ResponseEntity.status(HttpStatus.OK).body(new ConsultaResponseDTO(consulta));
	}

	public ResponseEntity<Object> delete(Long id) {
		Consulta consulta = consultaRepository.findById(id).orElseThrow();
		consultaRepository.delete(consulta);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	public ResponseEntity<Object> create(@Valid ConsultaCreateDTO consultaDTO) {
	
		Paciente paciente = pacienteRepository.findById(consultaDTO.paciente_id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource Paciente not found"));
		
		Recepcionista recepcionista = recepcionistaRepository.findById(consultaDTO.recepcionista_id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource Recepcionista not found"));
		
		Medico medico = medicoRepository.findById(consultaDTO.medico_id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource Medico not found"));
		
		Calendario data = calendarioRepository.findByData(LocalDate.parse(consultaDTO.data_consulta))
				.orElseThrow(() -> new ResourceNotFoundException("Resource Data not found"));
		
		Consulta consulta = new Consulta(consultaDTO);
		consulta.setData(data);
		consulta.setMedico(medico);
		consulta.setRecepcionista(recepcionista);
		consulta.setPaciente(paciente);		
		consultaRepository.save(consulta);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ConsultaResponseDTO(consulta));
	}

	public ResponseEntity<Object> findById(Long id) {
		Consulta consulta = consultaRepository.findById(id).orElseThrow();		
		return ResponseEntity.status(HttpStatus.OK).body(new ConsultaResponseDTO(consulta));
	}
}
