package com.ayesa.service.personaservice;

import java.util.List;

public interface PersonaService <T>{
	
	String crearPersona(T t);
	List<T> buscarPersonas();
	List<T> buscarPersona(T t);
	String actualizarPersona(T t, T t2);
	String borrarPersona(T t);
	

}
