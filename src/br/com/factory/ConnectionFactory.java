package br.com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static String url = "jdbc:mysql://localhost:3306/consultorio?useTimezone=true&serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String senha = "123";
		
	public Connection getConection() {
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
