package br.com.alura.lolja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lolja.modelo.Pedido;
import br.com.alura.lolja.vo.RelatorioDeVendasVo;

public class PedidoDAO {
	private EntityManager entityManager;
	
	public PedidoDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Pedido pedido) {
		this.entityManager.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(pedido.valorTotal) FROM Pedido AS pedido";
		return entityManager.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	// Me retorna uma List de Array de Objetos, ou seja, eu tenho uma lista/array em que dentro dessa 
	// lista eu vou ter um outro array/lista.
	// public List<Object[]> relatorioDeVendas() {
	// Classe Value Object, ou seja, esta classe apenas tem atributos, getter e setter, sem estados e comportamentos.
		/*String jpql = "SELECT produto.nome,"
				+ " SUM(item.quantidade),"
				+ " MAX(pedido.data)"
				+ " FROM Pedido AS pedido"
				+ " JOIN pedido.itens AS item"
				+ " JOIN item.produto AS produto"
				+ " GROUP BY produto.nome"
				+ " ORDER BY item.quantidade DESC"; */
	public List<RelatorioDeVendasVo> relatorioDeVendas() {
		// Quando tem um select new, a JPA, sabe que eh pra criar uma instancia desta classe e ela vai 
		// passar estes valores para o construtor, e para cada registro ela vai crair um objeto
		// e jogar em uma lista.
		String jpql = "SELECT new br.com.alura.lolja.vo.RelatorioDeVendasVo("
				+ " produto.nome,"
				+ " SUM(item.quantidade),"
				+ " MAX(pedido.data))"
				+ " FROM Pedido AS pedido"
				+ " JOIN pedido.itens AS item"
				+ " JOIN item.produto AS produto"
				+ " GROUP BY produto.nome"
				+ " ORDER BY item.quantidade DESC";
		return entityManager.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
	}
	
	// Query Planejada - Eu planejo tudo o que preciso carregar
	public Pedido buscarPedidoComCliente(Long id) {
		return entityManager
				// Ja carregue a tabela Cliente junto
				// JOIN FETCH ja busque junto o relacionamento pedido.cliente, eh como se ele virasse EAGER.
				// Ou seja, no mesmo resultado da consulta, ele vai trazer os dados da tabela cliente tambem.
				.createQuery("SELECT pedido from Pedido pedido JOIN FETCH pedido.cliente WHERE pedido.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
