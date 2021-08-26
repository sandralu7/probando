package baseDatos;

import java.sql.*;

public class EjemploBaseDatosUpdate {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:8889/concesionario";
            Connection conexion = DriverManager.getConnection(url, "root", "root");
            String sentencia = "DELETE FROM Vendedores where documento_vendedor = " + "1379";
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate(sentencia);
            conexion.close();
            
            
            
        } catch (ClassNotFoundException e) {
            System.out.println("No fue posible cargar el driver.");
        } catch (SQLException e) {
            System.out.println("Hubo un error al acceder a la base de datos: " + e.getMessage());
        }

    }
}
