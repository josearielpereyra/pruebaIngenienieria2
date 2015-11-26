package com.arielpereyra.interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MetodosUtilitarios {

	protected static void agregarMenu(final JFrame ventana) {
		JMenuBar barraMenu = new JMenuBar();
		ventana.setJMenuBar(barraMenu);
		JMenu menuArchivo = new JMenu("Archivo");
		barraMenu.add(menuArchivo);
		
		JMenuItem menuItemSalir = new JMenuItem("Salir");
		menuArchivo.add(menuItemSalir);	
		
		menuItemSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodosUtilitarios.confirmarCierre(ventana);
			}
		});
	}
	
	protected static void confirmarCierre(JFrame ventana) {
		int opcion = JOptionPane.showConfirmDialog(	ventana, "Desea Cerrar La Aplicacion?",
										"Confirmacion", JOptionPane.YES_NO_OPTION);
		
		if( opcion == JOptionPane.YES_OPTION )
		{
			ventana.dispose();
		}
	}
}
