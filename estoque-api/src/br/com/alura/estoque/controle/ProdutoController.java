package br.com.alura.estoque.controle;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.estoque.dao.ProdutoDao;
import br.com.alura.estoque.modelo.Produto;

public class ProdutoController {
	
	// private ProdutoDaoMock produtoDao;
	private ProdutoDao produtoDao;

	/* Instanciando Controllers que tenham depedencias a serem instanciadas
	 * n�o podem ter o controlador padr�o
	public ProdutoController() {
		// produtoDao = new ProdutoDaoMock();
	}*/
	
	/*public ProdutoController(ProdutoDaoMock produtoDao) {
		this.produtoDao = produtoDao;
	}*/
	
	// Isso � uma interface, por�m no mesmo projeto eu tenho a implementa��o dela.
	public ProdutoController(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	public List<Produto> lista() {
		return produtoDao.lista();
	}
	
	public List<Produto> filtra(String nome) {
		return produtoDao.lista().stream()
							.filter(produto -> produto.getNome().toLowerCase().startsWith(nome.toLowerCase()))
							.collect(Collectors.toList());
	}
	
	public List<Produto> filtra(String nome, String marca) {
		return produtoDao.lista().stream()
							.filter(produto -> 
								produto.getNome().toLowerCase().startsWith(nome.toLowerCase())
								&& produto.getMarca().equalsIgnoreCase(marca)
							)
							.collect(Collectors.toList());
	}
}
