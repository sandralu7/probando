package co.com.controlador;

import java.sql.SQLException;
import java.sql.Statement;

import co.com.modelo.Conexion;
import co.com.modelo.Vendedor;

public class VendedorDAO {
	
	public void guardarVendedor (Vendedor vendedor) {
		Conexion conex = new Conexion();
		
        String sentencia = "INSERT INTO vendedores (documento_vendedor,nombres,apellidos,ciudad) VALUES ('" + vendedor.getDocumentoVendedor()+ "','"+vendedor.getNombres()+"','"+vendedor.getApellidos()+"','"+vendedor.getCiudad()+"');";
        Statement consulta;
		try {
			consulta = conex.getConnection().createStatement();
			consulta.executeUpdate(sentencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        conex.desconectar();;
	}

}
