package com.clinica.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.clinica.backend.dto.paciente.PacienteRequestDTO;
import com.clinica.backend.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PacienteControllerTests {
  @MockBean
  private PacienteRepository pacienteRepository;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;
  
  @Test
  public void getShouldReturn401unauthorized() throws Exception {
    
    this.mockMvc.perform(get("/paciente"))
    .andExpect(status().isUnauthorized())
    .andDo(print());;
  }
  
  @Test
  public void postShouldReturn401unauthorized() throws Exception {
	  PacienteRequestDTO paciente = new PacienteRequestDTO();
	  this.mockMvc.perform(post("/paciente").contentType(MediaType.APPLICATION_JSON)
		        .content(objectMapper.writeValueAsString(paciente)))
		        .andExpect(status().isUnauthorized())
		        .andDo(print());
  }
  
  @Test
  public void putShouldReturn401unauthorized() throws Exception {
	  this.mockMvc.perform(put("/paciente/1"))
	  .andExpect(status().isUnauthorized())
	  .andDo(print());;
  }
  
  @Test
  public void deleteShouldReturn401unauthorized() throws Exception {
	  this.mockMvc.perform(delete("/paciente/1"))
	  .andExpect(status().isUnauthorized())
	  .andDo(print());;
  }
}

