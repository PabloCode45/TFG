package com.ayesa.model;

import java.util.Objects;

public class Persona {


	private int id;
	private String nombre = null;
	private String apellidos = null;

	// factoría
	public static Persona createPersona(String nombre, String apellidos, int id) {
		return new Persona(nombre, apellidos, id);
	}

	private Persona(String nombre, String apellidos, int id) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id=id;

	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setApellidos(String apellido) {
		this.apellidos = apellido;
	}

	public int compareTo(Persona o) {

		int resultado = this.nombre.compareTo(o.nombre);
		if (resultado == 0) {
			if ((resultado = this.apellidos.compareTo(o.apellidos)) == 0) {
				if(this.id==o.id) {
					return resultado;
				}
			}
		}

		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(nombre, other.nombre) && Objects.equals(id, other.id);
	}

}
