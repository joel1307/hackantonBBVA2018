
package Conexion;

import java.sql.*;

/**
 * Esta clase permite realizar conexiones a la Base de Datos para generar
 * reportes
 *
 * @author: Herzh
 * @version: 1.0
 */
public class ConexionReport {

    Connection cn;

    /**
     * Constructor de la clase
     *
     * @return cn, es una conexion
     */
    public Connection conexionReport() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            /* LOCAL solo para pruebas */
            cn = DriverManager.getConnection("jdbc:mysql://localhost/clinica_DB", "root", "mySql-11");

            /* PRODUCTION, es para el servidor */
            //cn = DriverManager.getConnection("jdbc:mysql://192.168.100.2/clinica_DB", "admin", "mySql-11");
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return cn;
    }

    /**
     * Este metodo nos avisa si hay algun error
     */
    Statement createStatement() {
        throw new UnsupportedOperationException("No soportado");
    }

}
