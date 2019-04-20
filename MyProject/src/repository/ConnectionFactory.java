package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConectar() {

		try {
			
			System.out.println("Conectado com sucesso!");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/empresax", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		
	}

}
