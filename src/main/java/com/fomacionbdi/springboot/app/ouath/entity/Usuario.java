package com.fomacionbdi.springboot.app.ouath.entity;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = -3273418578963479944L;
	private String nombre;
	private String apellido;

	public Usuario() {
	}

	public Usuario(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
