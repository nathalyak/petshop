package br.com.petshop.gerenciador.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	private static Connection connection;
	public static PreparedStatement conecta(String sql) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection =DriverManager.getConnection("jdbc:mysql://localhost/dbPetShop?"
				+ "user=root&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false"
				+ "&serverTimezone=UTC");
		
		System.out.println("conectado com o banco de dados");
		
	
		PreparedStatement statement = connection.prepareStatement(sql);

		return statement;
	}
	
	
	public static void desconecta() throws SQLException {
			connection.close();
	}
}
