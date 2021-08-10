package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import loja_virtual_repository.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Comoda", "Comoda Vertical");
	
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
			
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, produto.getNome());
				preparedStatement.setString(2, produto.getDescricao());
				
				preparedStatement.execute();
				
				try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
					while(resultSet.next()) {
						produto.setId(resultSet.getInt(1));
					}
				}
			}
		}
	}

}
