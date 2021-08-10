package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import loja_virtual_repository.dao.CategoriaDAO;
import loja_virtual_repository.dao.ProdutoDAO;
import loja_virtual_repository.modelo.Categoria;
import loja_virtual_repository.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
			
			listaDeCategorias.forEach(listaDeCategoriasLambda -> { 
				System.out.println(listaDeCategoriasLambda.getNome());
				for(Produto produto : listaDeCategoriasLambda.getProdutos()) {
					System.out.println(listaDeCategoriasLambda.getNome() + " - " + produto.getNome());
				}
			});
		}
	}

}
