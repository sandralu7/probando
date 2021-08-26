package co.com.controlador;

import java.sql.*;

import co.com.modelo.*;

import java.util.*;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class VehiculoDAO {

	
	public List  <Vehiculo> buscarVehiculos() {

		  Conexion conex = new Conexion();
		  List<Vehiculo> miLista = new ArrayList<Vehiculo>();
		  Vehiculo vehiculo;
		  try {
		   Statement statement = conex.getConnection().createStatement();
		   ResultSet rs = statement.executeQuery("SELECT * FROM Vehiculos ");

		   while (rs.next()) {
		    vehiculo = new Vehiculo();
		    vehiculo.setPlaca(rs.getString("placa"));
		    vehiculo.setMarca(rs.getString("marca"));
		    vehiculo.setModelo(rs.getString("modelo"));
		    vehiculo.setKilometraje(rs.getString("kilometraje"));
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    if(rs.getDate("fecha_venta")!= null)
		    	vehiculo.setFechaVenta(sdf.format(rs.getDate("fecha_venta")));
		    
		    Vendedor vendedor = new Vendedor();
		    vendedor.setDocumentoVendedor(rs.getInt("documento_vendedor"));
		    vehiculo.setVendedor(vendedor);
		    
		 
		    miLista.add(vehiculo);
		   }
		   //rs.close();
		   conex.desconectar();

		  } catch (SQLException e) {
		   System.out.println(e.getMessage());
		   JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
		     JOptionPane.ERROR_MESSAGE);

		  }
		  return miLista;
		 }
}
