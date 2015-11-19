package com.arielpereyra.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.arielpereyra.objetosDeDatos.Contacto;

public class BaseDeDatos {
	private String controlador;
	private String rutaALaBaseDeDatos;
	private String usuario;
	private String clave;
	
	Connection conexion;// maneja la conexión
	Statement instruccion;// instrucción de consulta
	ResultSet conjuntoResultados;// maneja los resultados
	
	public BaseDeDatos(String controlador, String rutaALaBaseDeDatos, String usuario, String clave) {
		this.controlador = controlador;
		this.rutaALaBaseDeDatos = rutaALaBaseDeDatos;
		this.usuario = usuario;
		this.clave = clave;
		
	}
	
	public void conectar() throws ClassNotFoundException, SQLException
	{
		Class.forName(controlador);
		conexion = DriverManager.getConnection(rutaALaBaseDeDatos, usuario, clave);
	}
	
	public ResultSet obtenerDatosDe(String tabla) throws SQLException
	{
		instruccion = conexion.createStatement();
		conjuntoResultados = instruccion.executeQuery("SELECT * FROM " + tabla);
		return conjuntoResultados;
	}
	
	public Connection obtenerConexion()
	{
		return conexion;
	}
}