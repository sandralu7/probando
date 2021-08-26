package co.com.vista;


import co.com.modelo.*;
import co.com.controlador.*;

import java.util.*;


public class Principal {

	public static void main(String[] args) {
	

		List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		
		VehiculoDAO vehiculoDAO = new VehiculoDAO();
		listaVehiculos =  vehiculoDAO.buscarVehiculos();
		
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo.getMarca());
			if(vehiculo.getVendedor()!=null)
				System.out.println(vehiculo.getVendedor().getDocumentoVendedor());
			
		}
		
		
		VentanaConsulta miVentanaConsulta;
		  miVentanaConsulta= new VentanaConsulta();
		  miVentanaConsulta.setVisible(true);

	}

}
