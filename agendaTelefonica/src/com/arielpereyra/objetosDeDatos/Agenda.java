package com.arielpereyra.objetosDeDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.arielpereyra.accesoADatos.BaseDeDatos;

public class Agenda {
	
	private Vector<Contacto> contactos;
	private Vector<Vector<String>> datosContactos;
	private Vector<String> nombresDeColumnas;
	
	public Agenda() {		
		actualizarContactos();
	}
	
	public Vector<Contacto> obtenerContactos()
	{
		return contactos;
	}
	
	public Vector<String> obtenerNombresDeColumnas()
	{
		return nombresDeColumnas;
	}
	
	public Vector<Vector<String>> obtenerDatosContactos()
	{
		return datosContactos;
	}
		
	
	public void actualizarContactos() {
		contactos = new Vector<>();
		datosContactos = new Vector<>();
		nombresDeColumnas = new Vector<>();
		
		try {	
			BaseDeDatos baseDeDatos = new BaseDeDatos("com.mysql.jdbc.Driver", 
				"jdbc:mysql://localhost:3306/agenda", "root", "1234");		
		
			baseDeDatos.conectar();
			ResultSet resultado = baseDeDatos.obtenerDatosDe("contactos");
			
			ResultSetMetaData metadatos = resultado.getMetaData();
			int columnas = metadatos.getColumnCount();
			
			for (int i = 2; i <= columnas; i++) {
				nombresDeColumnas.add(metadatos.getColumnName(i));
			}
			
			while( resultado.next() )
			{
				String nombre= resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String email = resultado.getString("email");
				String telefono= resultado.getString("telefono");
				String direccion= resultado.getString("direccion");
				
				Vector<String> contacto = new Vector<>();
				
				contacto.add(nombre);
				contacto.add(apellidos);
				contacto.add(email);
				contacto.add(telefono);
				contacto.add(direccion);
				
				datosContactos.add(contacto);
				
				Contacto contactoActual = new Contacto(nombre, apellidos, email, telefono, direccion);
				contactos.add( contactoActual );
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos...");
		}
	}
	
	public void guardarContacto(Contacto contacto)
	{
		
		try {
			BaseDeDatos baseDeDatos = new BaseDeDatos("com.mysql.jdbc.Driver", 
				"jdbc:mysql://localhost:3306/agenda", "root", "1234");		
		
			baseDeDatos.conectar();
			
			String sql = "INSERT INTO contactos (nombre, apellidos, email, telefono, direccion)";
			sql += " VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement insercion = baseDeDatos.obtenerConexion().prepareStatement(sql);
			insercion.setString( 1, contacto.obtenerNombre() );
			insercion.setString( 2, contacto.obtenerApellidos() );
			insercion.setString( 3, contacto.obtenerEmail() );
			insercion.setString( 4, contacto.obtenerTelefono() );
			insercion.setString( 5, contacto.obtenerDireccion() );
			
			insercion.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos...");
		}
	}
}