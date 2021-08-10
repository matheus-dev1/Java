package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
	
		System.out.println("Tudo certo =)");
		
		connection.close();
	}
}
