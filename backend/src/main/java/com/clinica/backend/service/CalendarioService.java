package com.clinica.backend.service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clinica.backend.dto.calendario.CalendarioRequestDTO;
import com.clinica.backend.dto.calendario.CalendarioResponseDTO;
import com.clinica.backend.exception.InvalidDateParamException;
import com.clinica.backend.model.Calendario;
import com.clinica.backend.repository.CalendarioRepository;

@Service
public class CalendarioService {
	@Autowired
	CalendarioRepository calendarioRepository;
	
	public ResponseEntity<Object> insert(CalendarioRequestDTO calendarioDTO) {

		if (calendarioDTO.getDataInicial().isAfter(calendarioDTO.getDataFinal())) {
			throw new InvalidDateParamException("Inital date must be before final date");
		}
		
		LocalDate currentDate = calendarioDTO.getDataInicial();
		Long numOfDays = currentDate.until(calendarioDTO.getDataFinal(), ChronoUnit.DAYS);
		ArrayList<LocalDate> alreadyIncludedDates = new ArrayList<>();
		
		// Insere datas no calendário, verifica e adiciona datas repetidas em uma array. V2
		for (int i = 0; i <= numOfDays; i++) {				
			if (calendarioRepository.findByData(currentDate.plusDays(i)).isEmpty()) {
				calendarioRepository.save(new Calendario(currentDate.plusDays(i)));
			} else {
				alreadyIncludedDates.add(currentDate);
			}
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Non included duplicates: " + alreadyIncludedDates.size());
	}

	public ResponseEntity<Object> getDay(Integer year, Integer month, Integer day) {
		LocalDate date = LocalDate.of(year, month, day);
		Calendario dateContent = calendarioRepository.findByData(date).orElseThrow();
		return ResponseEntity.status(HttpStatus.OK).body(new CalendarioResponseDTO(dateContent));
	}
	
	public ResponseEntity<Object> getDay(Integer year,Integer month ,Integer day, Integer interval) {
		try {
			LocalDate data = LocalDate.of(year, month, day);
			Set<Calendario> intervaloDatas = calendarioRepository.findByData(data, data.plusDays(interval));
			return ResponseEntity.status(HttpStatus.OK).body(intervaloDatas.stream().map(dia -> new CalendarioResponseDTO(dia)));
		} catch (DateTimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data invalida");
		}
	}

	public ResponseEntity<Object> getMonth(Integer year, Integer month) {
		try {
			LocalDate data = LocalDate.of(year, month, 1);
			Set<Calendario> mes = calendarioRepository.findByData(data, data.plusMonths(1).minusDays(1));
			return ResponseEntity.status(HttpStatus.OK).body(mes.stream().map(dia -> new CalendarioResponseDTO(dia)));
		} catch (DateTimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data invalida");
		}
	}

	public ResponseEntity<Object> getYear(Integer year) {
		try {
			LocalDate data = LocalDate.of(year, 1, 1);
			Set<Calendario> ano = calendarioRepository.findByData(data, data.plusYears(1).minusDays(1));
			return ResponseEntity.status(HttpStatus.OK).body(ano.stream().map(dia -> new CalendarioResponseDTO(dia)));
		} catch (DateTimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("data invalida");
		}
	}
}
