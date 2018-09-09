package Conexion;

import java.sql.*;

/**
 * Esta clase es usada por los permite realizar conexiones a la Base de Datos
 * @author: Herzh
 * @version: 1.0
 */
public class Conexion {

	/**
     * Cadenas con los datos de Conexion
     */
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static Driver driver = null;
	
	/* Datos Locales */
	private static final String JDBC_URL = "jdbc:mysql://localhost/clinica_DB?useSSL=false";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "mySql-11";
//	
//	/*Datos Reales*/
//	private static final String JDBC_URL = "jdbc:mysql://192.168.100.2/clinica_DB?useSSL=false";
//	private static final String JDBC_USER = "admin";
//	private static final String JDBC_PASS = "mySql-11";

	/**
     * Para que no haya problemas al obtener la conexion de
	 * manera concurrente, en este metodo se usa la palabra synchronized
	 * @return connection
	 * @throws java.sql.SQLException
     */
	public static synchronized Connection getConnection()
			throws SQLException {
		if (driver == null) {
			try {
				//Se registra el driver
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
				System.out.println("Fallo en cargar el driver JDBC");
			}
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	/**
     * Este metodo Cierra el resultSet
	 * @param rs Recibe el valor ResulSet
     */
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException sqle) {
		}
	}

	/**
     * Es metodo para el Cierre del PrepareStatement
	 * @param stmt Recibe el valor PreparedStatement
     */
	public static void close(PreparedStatement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException sqle) {
		}
	}

	/**
     * Este metodo Cierra la conexion
	 * @param conn Recibe el valor Connection
     */
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException sqle) {
		}
	}
}
