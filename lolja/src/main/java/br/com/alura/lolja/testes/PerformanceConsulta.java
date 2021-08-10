package br.com.alura.lolja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.internal.build.AllowSysOut;

import br.com.alura.lolja.dao.CategoriaDAO;
import br.com.alura.lolja.dao.ClienteDAO;
import br.com.alura.lolja.dao.PedidoDAO;
import br.com.alura.lolja.dao.ProdutoDAO;
import br.com.alura.lolja.modelo.Categoria;
import br.com.alura.lolja.modelo.Cliente;
import br.com.alura.lolja.modelo.ItemPedido;
import br.com.alura.lolja.modelo.Pedido;
import br.com.alura.lolja.modelo.Produto;
import br.com.alura.lolja.util.JPAUtil;
import br.com.alura.lolja.vo.RelatorioDeVendasVo;

public class PerformanceConsulta {

	public static void main(String[] args) {
		PopularBancoDeDados();
		EntityManager entityManager = JPAUtil.getEntityManager();
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		// Pedido pedido = entityManager.find(Pedido.class, 1l);
		Pedido pedido = pedidoDAO.buscarPedidoComCliente(1l);
		entityManager.close();
		System.out.println(pedido.getCliente().getNome());
	}
	
	private static void PopularBancoDeDados() {
		// Cria Categoria, produto e cliente.
		Categoria categoria = new Categoria("CELULARES");
		Categoria categoria1 = new Categoria("VIDEOGAMES");
		Categoria categoria2 = new Categoria("INFORMATICA");
		
		Produto produto = new Produto("Xiaomi", "Muito legal", new BigDecimal("800"), categoria);
		Produto produto1 = new Produto("PS5", "Muito diferenciado", new BigDecimal("500"), categoria1);
		Produto produto2 = new Produto("Macbook", "Muito util", new BigDecimal("8000"), categoria2);
		
		Cliente cliente = new Cliente("Matheus", "232.232.534-33");
		
		Pedido pedido = new Pedido(cliente);
		ItemPedido itemPedido = new ItemPedido(10, pedido, produto);
		pedido.adicionarPedido(itemPedido);
		
		Pedido pedido2 = new Pedido(cliente);
		ItemPedido itemPedido1 = new ItemPedido(30, pedido, produto2);
		pedido.adicionarPedido(itemPedido1);
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ClienteDAO clienteDAO = new ClienteDAO(entityManager);
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		
		entityManager.getTransaction().begin();
		
		pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);
		
		produtoDAO.cadastrar(produto);
		produtoDAO.cadastrar(produto1);
		produtoDAO.cadastrar(produto2);
		
		categoriaDAO.cadastrar(categoria);
		categoriaDAO.cadastrar(categoria1);
		categoriaDAO.cadastrar(categoria2);
		
		clienteDAO.cadastrar(cliente);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
	
}
