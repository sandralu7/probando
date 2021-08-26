package co.com.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import co.com.controlador.VendedorDAO;
import co.com.modelo.Vendedor;

public class SwingDemo13 {
	
	private JFrame ventana;
	private JLabel bienvenidos, documento, nombre, apellido, ciudad;
	private JTextField texto1, texto2, texto3, texto4;
	private JButton boton1, boton2;
	
	public SwingDemo13() {
		
		ventana = new JFrame("Guardar Vendedor");
		ventana.setLayout(new GridLayout(5,2));
		ventana.setSize(500,200);
		
		bienvenidos = new JLabel("Bienvenidos");
		documento = new JLabel("Documento");
		nombre = new JLabel("Nombre");
		apellido = new JLabel("Apellido");
		ciudad = new JLabel("Ciudad");
		
		
		texto1 = new JTextField(10);
		texto2 = new JTextField(10);
		texto3 = new JTextField(10);
		texto4 = new JTextField(10);
		
		boton1 = new JButton("Agregar");
		boton2 = new JButton("Salir");
		
		boton1.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se agregó el usuario: " + agregar());
				
			}
		});
		
		boton2.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		ventana.getContentPane().add(documento);
		ventana.getContentPane().add(texto1);
		ventana.getContentPane().add(nombre);
		ventana.getContentPane().add(texto2);
		ventana.getContentPane().add(apellido);
		ventana.getContentPane().add(texto3);
		ventana.getContentPane().add(ciudad);
		ventana.getContentPane().add(texto4);
		ventana.getContentPane().add(boton1);
		ventana.getContentPane().add(boton2);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public String agregar () {
		
		try {
			int documento= Integer.parseInt(texto1.getText());
			String nombre= texto2.getText();
			String apellido= texto3.getText();
			String ciudad= texto4.getText();
			
			Vendedor vendedor = new Vendedor();
			vendedor.setDocumentoVendedor(documento);
			vendedor.setNombres(nombre);
			vendedor.setApellidos(apellido);
			vendedor.setCiudad(ciudad);
			
			VendedorDAO vendedorDao = new VendedorDAO();
			vendedorDao.guardarVendedor(vendedor);
			
			return vendedor.getNombres() + " " + vendedor.getApellidos();
			
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de lectura de datos");
			return "Error";
		}
		
		
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
		
			public void run() {
				new SwingDemo13();
				
			}
		});

	}

}
