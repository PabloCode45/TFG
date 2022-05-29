package com.ayesa.dtos;

import java.util.Objects;

public class PersonaDTO {
	
	protected int id;
	
	protected String nombre;
	
	protected String apellidos;
	
	public PersonaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PersonaDTO(int id, String nombre, String apellidos) {
		this.id=id;
		this.nombre=nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaDTO other = (PersonaDTO) obj;
		return Objects.equals(apellidos, other.apellidos) && id == other.id && Objects.equals(nombre, other.nombre);
	}	

}