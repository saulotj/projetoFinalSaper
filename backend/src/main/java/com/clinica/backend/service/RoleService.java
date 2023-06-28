package com.clinica.backend.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.backend.enums.RoleNames;
import com.clinica.backend.model.Administrador;
import com.clinica.backend.model.Medico;
import com.clinica.backend.model.Recepcionista;
import com.clinica.backend.model.Role;
import com.clinica.backend.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	public void setRoleAsRecepcionista(Recepcionista recepcionista) {
		Optional<Role> roleOptional = roleRepository.findByRole(RoleNames.ROLE_RECEPCIONISTA);
		Set<Role> newRoles = new HashSet<>();
		newRoles.add(roleOptional.get());
		recepcionista.setRoles(newRoles);
	}
	
	public void setRoleAsMedico(Medico medico) {
		Optional<Role> roleOptional = roleRepository.findByRole(RoleNames.ROLE_MEDICO);
		Set<Role> newRoles = new HashSet<>();
		newRoles.add(roleOptional.get());
		medico.setRoles(newRoles);
	}
	
	public void setRoleAsAdmin(Administrador adm) {
		Optional<Role> roleOptional = roleRepository.findByRole(RoleNames.ROLE_ADM);
		Set<Role> newRoles = new HashSet<>();
		newRoles.add(roleOptional.get());
		adm.setRoles(newRoles);
	}
	
}
