package baseDatos;

import java.sql.*;

public class PruebaBaseDatos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            int documento;
            String nombres, apellidos, ciudad;
            //Se carga el driver correspondiente a MySQL (versión 8)
            Class.forName("com.mysql.cj.jdbc.Driver");
            /* Se obtiene una conexión a la base de datos usando el DriverManager
            Nos conectaremos a un servidor SQL en nuestra máquina (localhost)
            y a una base de datos existente llamada concesionario */
            String url = "jdbc:mysql://localhost:8889/concesionario";
            Connection conexion = DriverManager.getConnection(url, "root", "root");
            //Se crea una consulta, en este caso para obtener todos los registros de la tabla vendedores
            String sentencia = "SELECT * FROM vendedores;";
            Statement consulta = conexion.createStatement();
            //Se crea un ResultSet con los resultados de la consulta y se itera sobre el mismo
            ResultSet resultados = consulta.executeQuery(sentencia);
            while (resultados.next()) {
                documento = resultados.getInt("documento_vendedor");
                nombres = resultados.getString("nombres");
                apellidos = resultados.getString("apellidos");
                ciudad = resultados.getString("ciudad");
                System.out.println("Listado de Vendedores");
                System.out.println("Documento: " + documento +
                        "Nombres: " + nombres +
                        "Apellidos: " + apellidos +
                        "Ciudad" + ciudad);
            }
            conexion.close();
        } catch (ClassNotFoundException e) {
            System.out.println("No fue posible cargar el driver.");
        } catch (SQLException e) {
            System.out.println("Hubo un error al acceder a la base de datos: " + e.getMessage());
        }

	}

}
