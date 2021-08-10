package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagemPreparedStatement {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		boolean result = statement.execute();
		System.out.println(result);
		
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			Integer id = resultSet.getInt("ID");
			String nome = resultSet.getString("NOME");
			String descricao = resultSet.getString("DESCRICAO");
			System.out.print("id: " + id + " - ");
			System.out.print("nome: " + nome + " - ");
			System.out.println("descricao: " + descricao);
		}
		
		connection.close();

	}

}
