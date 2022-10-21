package br.com.alura.estoque.dao;

import java.util.Arrays;
import java.util.List;

import br.com.alura.estoque.modelo.Produto;

public class ProdutoDaoMock implements ProdutoDao {
	
	public ProdutoDaoMock() { }
	
	private static final List<Produto> LISTA_PRODUTO = 
			Arrays.asList(new Produto("Produto1", 20.0, "Marca1"),
					new Produto("Produto2", 30.0, "Marca1"),
					new Produto("Produto3", 40.0, "Marca2"));
	
	public List<Produto> lista() {
		return LISTA_PRODUTO;
	}
	
	public Produto getProduto(Integer id) {
		return LISTA_PRODUTO.get(id);
	}
}
