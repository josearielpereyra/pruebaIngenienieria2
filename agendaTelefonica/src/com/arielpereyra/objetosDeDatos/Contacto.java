package com.arielpereyra.objetosDeDatos;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.arielpereyra.accesoADatos.BaseDeDatos;

public class Contacto {	
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	private String direccion;
	
	public Contacto(String nombre, String apellidos, String email,
			String telefono, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public void establecerNombre(String nombre) {
		this.nombre = nombre;
	}

	public String obtenerApellidos() {
		return apellidos;
	}

	public void establecerApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String obtenerEmail() {
		return email;
	}

	public void establecerEmail(String email) {
		this.email = email;
	}

	public String obtenerTelefono() {
		return telefono;
	}

	public void establecerTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String obtenerDireccion() {
		return direccion;
	}

	public void establecerDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "[nombre = " + nombre + "][apellidos = " + apellidos + "][email = " + email + 
				"][telefono = " + telefono + "][direccion = " + direccion + "]";
	}
}
