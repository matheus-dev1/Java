package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement statement = connection.createStatement();
		
		statement.execute("DELETE FROM PRODUTO WHERE ID > 2;");
		
		// Quantas linhas foram modificadas apos o ultimo statement ser executado.
		Integer linhasModificadas = statement.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
	}

}
