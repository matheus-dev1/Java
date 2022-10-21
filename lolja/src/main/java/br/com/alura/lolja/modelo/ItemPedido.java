package br.com.alura.lolja.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Preco na data da venda do produto.
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	private Integer quantidade;
	
	/* Pelo fato de ItemPedido ter virado uma nova entidade, vamos usar o ManyToOne para pedido e produto, ou seja, um pedido pode ter varios itens, e cada item tem apenas um produto vinculado. */
	
	/* Aqui eu estou mapeando os dois lados do relacionamento, ou seja, de ItemPedido eu to mapeando o pedido e de pedido eu to mapeando pedido, um mapeando bidirecional, ou seja, eu estou mapeando os dois lados. */
	
	/* Por padrao se eu nao declarar que isso eh um relacionamento bidimencional, o hibernate vai pensar que isso aqui eh um novo relacionamento e vai criar um tabela nova com a juncao dos ids de pedido e itensPedido */
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;
	
	public ItemPedido() {
		
	}
	
	public ItemPedido(Integer quantidade, Pedido pedido, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
		//Aqui eu ja seto o preco, para caso haja um alteracao, o pedido ja registrado nao sofra alteracao.
		this.precoUnitario = produto.getPreco();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValor() {
		// Multiplicar o valor do produto com a quantiade de produtos.
		return precoUnitario.multiply(new BigDecimal(quantidade));
	}
}
