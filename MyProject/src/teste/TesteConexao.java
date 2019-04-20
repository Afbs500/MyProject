package teste;

import java.sql.Connection;
import java.sql.SQLException;

import repository.ConnectionFactory;

public class TesteConexao {
	
	
	public static void main(String[] args) throws SQLException {
		
	Connection conn = new ConnectionFactory().getConectar();
	
	}
	

}
