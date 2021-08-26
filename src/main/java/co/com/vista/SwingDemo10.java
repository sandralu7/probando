package co.com.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import co.com.controlador.VehiculoDAO;
import co.com.modelo.Vehiculo;

public class SwingDemo10 {
	
	 private JLabel labelTitulo;
	 JTable miTabla1;
	 JScrollPane mibarra1;
	 private JButton agregarBtn;
	
	SwingDemo10(){
		
		JFrame ventana = new JFrame("Formulario Swing");
		Container contenedor  = ventana.getContentPane();
		
		ventana.setSize(200, 281);
		ventana.setTitle("Concesionario");
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(true);
		  
		inicializaComponentes(contenedor);
		construirTabla();
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.pack();
		ventana.setVisible(true);
		
	}
	
	private void inicializaComponentes(Container contenedor) {
		  JPanel panelNorte = new JPanel();
		  contenedor.add(panelNorte, BorderLayout.CENTER);

		  labelTitulo = new JLabel();
		  labelTitulo.setBounds(27, 11, 400, 30);
		  labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		  labelTitulo.setText("CONSULTA DE VEHICULOS");
		  labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		  contenedor.add(labelTitulo, BorderLayout.NORTH);
		  
		  mibarra1=new JScrollPane();
		  mibarra1.setBounds(27, 72,400,130);
		  contenedor.add(mibarra1, BorderLayout.LINE_END);
			
		  agregarBtn = new JButton("Agregar Vendedor");
		  agregarBtn.setBounds(335, 219, 89, 23);
		  contenedor.add(agregarBtn, BorderLayout.SOUTH);
			  
		  ActionListener a2 = new ActionListener() {
					
					
			  public void actionPerformed(ActionEvent e) {
				 if (e.getSource()==agregarBtn) {
							  new SwingDemo13();
			    }
							
			  }
		  };
		 agregarBtn.addActionListener(a2);
			
			
		   
		 }
		 
		 private void construirTabla() {
			  String titulos[]={ "Placa", "Modelo", "Kilometraje", "Fecha de Venta","Vendedor" };
			  String informacion[][]=obtenerMatriz();
			  
			  miTabla1=new JTable(informacion,titulos);
			  mibarra1.setViewportView(miTabla1);
		  
		 }

		 private String[][] obtenerMatriz() {
		  
			  VehiculoDAO miPersonaDao=new VehiculoDAO();
			  List <Vehiculo> miLista=miPersonaDao.buscarVehiculos();
			  
			  String matrizInfo[][]=new String[miLista.size()][5];
			  
			  for (int i = 0; i < miLista.size(); i++) {
			   matrizInfo[i][0]=miLista.get(i).getPlaca()+"";
			   matrizInfo[i][1]=miLista.get(i).getModelo()+"";
			   matrizInfo[i][2]=miLista.get(i).getKilometraje()+"";
			   matrizInfo[i][3]=miLista.get(i).getFechaVenta()+"";
			   if(miLista.get(i).getVendedor()!= null)
			   matrizInfo[i][4]=miLista.get(i).getVendedor().getDocumentoVendedor()+"";
			  }
			   
			  return matrizInfo;
		 }


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new SwingDemo10();
				
			}
		});

	}

}
