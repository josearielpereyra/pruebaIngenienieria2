package com.arielpereyra.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.arielpereyra.objetosDeDatos.Agenda;
import com.arielpereyra.objetosDeDatos.Contacto;
import com.mysql.jdbc.log.Jdk14Logger;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame{
	private JTable tablaDatos;
	private JPanel panelFoto;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	
	private JButton botonGuardar;
	private JButton botonCancelar;
	private JPanel formulario;
	private JPanel panelDatos;
	private Agenda agenda;
	private JPanel panelCamposDeTexto;
	
	public VentanaPrincipal()
	{
		super("Mi Agenda");
		setSize(new Dimension(600, 500));
		
		JPanel panelNorte = new JPanel( new BorderLayout() );
		panelNorte.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		panelFoto = new JPanel(new BorderLayout(20,20));
		panelFoto.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		JLabel etiquetaFoto = new JLabel("Foto");
		panelFoto.add(etiquetaFoto);
		etiquetaFoto.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		//((JLabel)(panelFoto.getComponent(0))).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panelNorte.add(panelFoto, BorderLayout.WEST);
		getContentPane().add(panelNorte, BorderLayout.NORTH);
			
		JPanel panelEtiquetas = new JPanel( new GridLayout(5, 1, 5, 5) );
		panelEtiquetas.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 5) );
		panelEtiquetas.add(new JLabel("Nombre:"));
		panelEtiquetas.add(new JLabel("Apellidos:"));
		panelEtiquetas.add(new JLabel("Email:"));
		panelEtiquetas.add(new JLabel("Telefono:"));
		panelEtiquetas.add(new JLabel("Direccion:"));
		
		Component[] etiquetas = panelEtiquetas.getComponents();
		for (int i = 0; i < etiquetas.length; i++) {
			((JLabel)etiquetas[i]).setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtEmail = new JTextField();
		txtTelefono = new JTextField();
		txtDireccion = new JTextField();
		
		panelCamposDeTexto = new JPanel( new GridLayout(5, 1, 5, 5) );
		panelCamposDeTexto.add(txtNombre);
		panelCamposDeTexto.add(txtApellido);
		panelCamposDeTexto.add(txtEmail);
		panelCamposDeTexto.add(txtTelefono);
		panelCamposDeTexto.add(txtDireccion);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Contacto nuevoContacto = new Contacto(txtNombre.getText(), txtApellido.getText(), 
						txtEmail.getText(), txtTelefono.getText(), txtDireccion.getText() );
				
				agenda.guardarContacto(nuevoContacto);
				
				System.out.println("entro aqui");
				actualizarTabla();
				limpiarCampos();
			}
		});
		botonCancelar = new JButton("Cancelar");
		
		JPanel panelBotones = new JPanel( new GridLayout(2, 1, 10, 10) );
		panelBotones.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		panelBotones.add(botonGuardar);
		panelBotones.add(botonCancelar);
		
		formulario = new JPanel(new BorderLayout());
		formulario.add(panelCamposDeTexto, BorderLayout.CENTER);	
		formulario.add(panelEtiquetas, BorderLayout.WEST);
		formulario.add(panelBotones, BorderLayout.EAST);
		panelNorte.add(formulario);
		
		panelDatos = new JPanel( new BorderLayout() );
		panelDatos.setBorder( new EmptyBorder(10, 20, 10, 20) );
		getContentPane().add(panelDatos, BorderLayout.CENTER);
		
		Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(tamanioPantalla.width/2 - getWidth()/2, tamanioPantalla.height/2 - getHeight()/2);
	
		agenda = new Agenda();	
		
		tablaDatos = new JTable( 	agenda.obtenerDatosContactos(), 
									agenda.obtenerNombresDeColumnas() );
		
		panelDatos.add(new JScrollPane( tablaDatos ));
	}
	
	public void actualizarTabla()
	{
		agenda.actualizarContactos();
		tablaDatos.setModel(
			new DefaultTableModel( agenda.obtenerDatosContactos(),agenda.obtenerNombresDeColumnas() ) );
		
	}
	
	public void limpiarCampos()
	{
		Component[] camposDeTexto = panelCamposDeTexto.getComponents();
		for (int i = 0; i < camposDeTexto.length; i++)
		{
			( (JTextField)camposDeTexto[i] ).setText("");
		}
	}

	public static void main(String[] args) {		
		VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
		miVentanaPrincipal.setVisible(true);
		
	}

}
