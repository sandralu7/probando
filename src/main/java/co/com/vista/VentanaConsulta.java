package co.com.vista;




import javax.swing.*;

import java.awt.event.*;



import java.util.*;

import co.com.controlador.VehiculoDAO;
import co.com.modelo.*;

public class VentanaConsulta extends JFrame implements ActionListener {

 private JLabel labelTitulo;
 JTable miTabla1;
 JScrollPane mibarra1;
 private JButton btnNewButton;

 /**
  * constructor de la clase donde se inicializan todos los componentes de la
  * ventana de registro
  */
 public VentanaConsulta() {
  setSize(462, 281);
  setTitle("Concesionario");
  setLocationRelativeTo(null);
  setResizable(false);
  
  inicializaComponentes();
  construirTabla();
 }

 private void inicializaComponentes() {
  getContentPane().setLayout(null);

  labelTitulo = new JLabel();
  labelTitulo.setBounds(27, 11, 400, 30);
  labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
  labelTitulo.setText("CONSULTA DE VEHICULOS");
  labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
  getContentPane().add(labelTitulo);
  
  mibarra1=new JScrollPane();
  mibarra1.setBounds(27, 72,400,130);
  getContentPane().add(mibarra1);
  
  btnNewButton = new JButton("Actualizar");
  btnNewButton.setBounds(335, 219, 89, 23);
  getContentPane().add(btnNewButton);
  btnNewButton.addActionListener(this);
   
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



 public void actionPerformed(ActionEvent e) {
  if (e.getSource()==btnNewButton) {
   construirTabla();
  }
 }
}