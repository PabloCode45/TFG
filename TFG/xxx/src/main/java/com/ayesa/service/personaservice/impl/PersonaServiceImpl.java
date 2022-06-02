package com.ayesa.service.personaservice.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ayesa.dtos.PersonaDTO;
import com.ayesa.model.PersonaCRUDRepository;
import com.ayesa.service.personaservice.PersonaService;

public class PersonaServiceImpl implements PersonaService<PersonaDTO> {
	
	private PersonaCRUDRepository personaCRUDRepository = new PersonaCRUDRepository();
	private String retVal = "Error - Persona ya existente o fallo SQL.";
	private String exito = "Operación realizada con éxito.";
	
	@Override
	public String crearPersona(PersonaDTO personaDTO) {
		if(personaCRUDRepository.create(personaDTO)) {
			retVal=exito;
			
		}
		
		return retVal;
	}
	
	@Override
	public List<PersonaDTO> buscarPersonas() {
		
		return personaCRUDRepository.readAll();
		
	}

	@Override
	public List<PersonaDTO> buscarPersona(PersonaDTO persona) {
		try {
			return personaCRUDRepository.readOne(persona);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();

		
	}

	@Override
	public String actualizarPersona(PersonaDTO personaDTO, PersonaDTO personaDTO2) {
		if(personaCRUDRepository.update(personaDTO, personaDTO2)) {
			retVal=exito;
			
		}
		
		return retVal;
	}

	@Override
	public String borrarPersona(PersonaDTO personaDTO) {
		if(personaCRUDRepository.delete(personaDTO)) {
			retVal=exito;
			
		}
		
		return retVal;
	}



}
