package loja_virtual_repository;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import loja_virtual_repository.dao.ProdutoDAO;
import loja_virtual_repository.modelo.Produto;

public class TestaInsercaoEListasgemComProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Comoda", "Comoda Vertical");
		
		// Usando a persistencia padrao, sendo que eu nao repeti codigo.
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			
			produtoDAO.salvar(produto);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			
			//Lambda - A cada interacao ele vai me executar o sysout depois da virgula.
			listaDeProdutos.stream().forEach(listaDeProdutosLambda -> System.out.println(listaDeProdutosLambda));
		}
	}

}
