package baseDatos;

import java.sql.*;

public class PruebaBaseDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            String placa;
            String marca, modelo;
            int kilometraje;
            //Se carga el driver correspondiente a MySQL (versión 8)
            Class.forName("com.mysql.cj.jdbc.Driver");
            /* Se obtiene una conexión a la base de datos usando el DriverManager
            Nos conectaremos a un servidor SQL en nuestra máquina (localhost)
            y a una base de datos existente llamada concesionario */
            String url = "jdbc:mysql://localhost:8889/concesionario";
            Connection conexion = DriverManager.getConnection(url, "root", "root");
            //Se crea una consulta, en este caso para obtener todos los registros de la tabla vendedores
            String sentencia = "SELECT placa, marca, modelo, kilometraje FROM vehiculos where marca = ? ;";
           PreparedStatement consulta = conexion.prepareStatement(sentencia);
           consulta.setString(1, "Renault");
            //Se crea un ResultSet con los resultados de la consulta y se itera sobre el mismo
            ResultSet resultados = consulta.executeQuery();
            while (resultados.next()) {
                placa = resultados.getString("placa");
                marca = resultados.getString("marca");
                modelo = resultados.getString("modelo");
                kilometraje = resultados.getInt("kilometraje");
                System.out.println("Listado de Vehiculos");
                System.out.println("Placa: " + placa +
                        "Marca: " + marca +
                        "Modelo: " + modelo +
                        "Kilometraje" + kilometraje);
            }
            conexion.close();
        } catch (ClassNotFoundException e) {
            System.out.println("No fue posible cargar el driver.");
        } catch (SQLException e) {
            System.out.println("Hubo un error al acceder a la base de datos: " + e.getMessage());
        }

	}

}
