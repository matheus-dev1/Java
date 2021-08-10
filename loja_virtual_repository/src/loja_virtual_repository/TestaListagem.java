package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement statement = connection.createStatement();
		
		// Se retornar TRUE eh porque eh uma lista de strings e seta os resultado.
		boolean result = statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		System.out.println(result);
		
		// Pego o conteudo setado por statement.execute();
		ResultSet resultSet = statement.getResultSet();
		
		// Ele comeca na posicao 0 e verifica se possui um proximo elemento no array, se tiver,
		// execute o bloco do white, se nao, quebre o laco.
		while(resultSet.next()) {
			// Posso pegar pelo indice do id (1) ou pelo ColumnLabel, ou seja, 
			// o nome da coluna (Id, nome , Descricao)
			Integer id = resultSet.getInt("ID");
			// Retornar um String a partir de um ColumnLabel.
			String nome = resultSet.getString("NOME");
			String descricao = resultSet.getString("DESCRICAO");
			System.out.print("id: " + id + " - ");
			System.out.print("nome: " + nome + " - ");
			System.out.println("descricao: " + descricao);
		}
		
		connection.close();

	}

}
