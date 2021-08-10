package br.com.alura.lolja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.lolja.dao.CategoriaDAO;
import br.com.alura.lolja.dao.ProdutoDAO;
import br.com.alura.lolja.modelo.Categoria;
import br.com.alura.lolja.modelo.CategoriaId;
import br.com.alura.lolja.modelo.Produto;
import br.com.alura.lolja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		cadastrarProduto();
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		
		Produto produto = produtoDAO.buscarPorId(1l);
		System.out.println(produto.getPreco());
		
		// List<Produto> listaDeProdutos = produtoDAO.buscarTodos();
		// listaDeProdutos.forEach(produtoNaLista -> System.out.println(produtoNaLista.getNome()));
		
		// List<Produto> listaDeProdutos = produtoDAO.buscarPorNome("Xiaomi");
		// listaDeProdutos.forEach(produtoNaLista -> System.out.println(produtoNaLista.getNome()));
		
		// List<Produto> listaDeProdutos = produtoDAO.buscarPorNomeDaCategoria("CELULARES");
		// listaDeProdutos.forEach(produtoNaLista -> System.out.println(produtoNaLista.getNome()));
		
		BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("Xiaomi");
		System.out.println(precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria categoria = new Categoria("CELULARES");
		
		// Por padrao quando nao definimos um tipo do valor que vai ser inserido, ele vai colocar a posicao 
		// do valor do enum, exemplo celular esta na primeira posicao entao o que vai ser registrado
		// vai ser 1, na tabela.
		Produto produto = new Produto("Xiaomi", "Muito legal", new BigDecimal("800"), categoria);
		
		// celular.setNome("Xiaomi");
		//celular.setDescricao("Muito legal");
		// Usamos o bigdecimal para representar dinheiro.
		// celular.setPreco(new BigDecimal("800"));
		
		// Na JPA toda vez que eu quero fazer uma operacao(query), eu preciso usar 
		// implementar a interface EntityManager
		
		// Para criar uma EntityManagerFactory pegamos o retorno do metodo estatico 
		// createEntityManagerFactory da classe Persisetnce, onde passamos como parametro ao metodo
		// o valor do persistence unit que configuramos.
		// EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lolja");
		
		// Agora vamos criar o entityManager genuinamente, atraves da factory
		// EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
		
		// Iniciar as tracacoes ao banco de dados, referente ao tipo da transacao que configuramos no 
		// persistence-unit
		entityManager.getTransaction().begin();
		
		// Inserir valor no banco de dados, passando o objeto em que voce quer adicionar 
		// os items como parametro 
		// entityManager.persist(celular);
		
		// Cadastro atraves da classe ProdutoDAO
		produtoDAO.cadastrar(produto);
		categoriaDAO.cadastrar(categoria);
		
		// Se nao der nenhum erro, ele vai commitar, ou seja, inserir genuinamente no banco de dados.
		entityManager.getTransaction().commit();
		
		// Pelo fato de estarmos usando uma chave composta, no segundo parametro devemos colocar a classe
		// que representa o id da class o primeiro argumento.
		entityManager.find(Categoria.class, new CategoriaId("CELULARES", "Tech"));
		
		// Fechar o recurso.
		entityManager.close();
	}

}
