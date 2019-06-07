package br.com.petshop.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {
		
		Connection con = null;
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PetShopFBD","postgres","010699");
			System.out.println("Conectada ao sistema!");
			
		} catch (SQLException e) {
			System.out.println("Erro - Conexão " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro - Driver" + e.getMessage());
		}return con;
		
	}
	
}
