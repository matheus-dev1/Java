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

public class CadastroDePedido {

	public static void main(String[] args) {
		// Cria uma categoria, produto e cliente.
		PopularBancoDeDados();
		
		// Criando entityManager para se conectar ao banco de dados.
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		// Iniciar a transacao.
		entityManager.getTransaction().begin();
		
		// DAO de produto.
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		
		// DAO de clienet.
		ClienteDAO clienteDAO = new ClienteDAO(entityManager);
		
		// Resgarando produto criado.
		Produto produto = produtoDAO.buscarPorId(1l);
		Produto produto2 = produtoDAO.buscarPorId(2l);
		
		// Resgarando cliente criado.
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		// Atrelnando um cliente que ja esta salvo, a criacao de um pedido.
		Pedido pedido = new Pedido(cliente);
		
		// Criando uma solicitacao de pedido com quantidade 10, referente a este pedido que esta atrelado
		// a um cliente e este pedido eh do produto tal.
		ItemPedido itemPedido = new ItemPedido(10, pedido, produto);
		
		ItemPedido itemPedido1 = new ItemPedido(30, pedido, produto2);
		
		// Adicionando o item do pedido a lista de pedidos e ao objeto ItemPedido.
		pedido.adicionarPedido(itemPedido);
		pedido.adicionarPedido(itemPedido1);
		
		Pedido pedido2 = new Pedido(cliente);
		
		// DAO de Pedido
		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		
		// Cadastrar o pedido em banco de dados.
		pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);
		
		// Commitar a transacao.
		entityManager.getTransaction().commit();
		
		// Armazenando o total do valor de todos os pedidos.
		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		
		// Exibindo o total do valor de todos os pedidos.
		System.out.println(totalVendido);
		
		// Ele eh inserido dinamicamente, ou seja, eu sei que eu vou ter 3 posicoes.
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();
		// Vai percorrer cada um dos elementos e da um sysout em cada um deles.
		relatorio.forEach(System.out::println);
		
		/* for (RelatorioDeVendasVo[] object : relatorio) {
			// Coluna de Nome do Produto
			System.out.print(object[0] + " - ");
			// Coluna de Soma da quantidade de itens de itens vendidos.
			System.out.print(object[1] + " - ");
			// Coluna de data da ultima venda.
			System.out.println(object[2]);
		}*/
		
		// Encerar a transacao.
		entityManager.close();

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
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ClienteDAO clienteDAO = new ClienteDAO(entityManager);
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
		
		entityManager.getTransaction().begin();
		
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
