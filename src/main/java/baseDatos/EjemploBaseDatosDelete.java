package baseDatos;

import java.sql.*;

public class EjemploBaseDatosDelete {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:8889/concesionario";
            Connection conexion = DriverManager.getConnection(url, "root", "root");
            String sentencia = "INSERT INTO vendedores (documento_vendedor,nombres,apellidos,ciudad) VALUES ('1379','Pepito','Pérez','Barranquilla');";
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
