package loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import loja_virtual_repository.modelo.Categoria;
import loja_virtual_repository.modelo.Produto;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO (Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) throws SQLException {
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
	
	public List<Produto> listar() throws SQLException {
		// Variavel para armazenar os produtos retornados.
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT * FROM PRODUTO";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.execute();
			
			try (ResultSet resultSet = preparedStatement.getResultSet()) {
				while(resultSet.next()) {
					// Sempre que tiver um novo produto, ele vai instanciar a classe com o construtor
					// que vai ter os valores JA SETADOS DO id, nome e descricao.
					// e vai armazenar na lista
					Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
					produtos.add(produto);
				}
			}
		}
		
		return produtos; 
	}

	public List<Produto> buscar(Categoria listaDeCategoriasLambda) throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		System.out.println("Executando a query de procurar produto por categoria.");
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			
			preparedStatement.setInt(1, listaDeCategoriasLambda.getIdCategoria());
			
			preparedStatement.execute();
			
			try (ResultSet resultSet = preparedStatement.getResultSet()) {
				while(resultSet.next()) {
					// Sempre que tiver um novo produto, ele vai instanciar a classe com o construtor
					// que vai ter os valores JA SETADOS DO id, nome e descricao.
					// e vai armazenar na lista
					Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
					produtos.add(produto);
				}
			}
		}
		
		return produtos;
	}
}
