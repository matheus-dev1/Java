package br.com.alura.lolja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Neste caso, como este atributo nao eh um relacionamento, ele vai manter o camelCase.
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();
	// Por padrao o hibernate sabe que se tem camelCase, na tabela, ele coloca underline, porem apenas 
	// para colunas de relacionamento, como por exemplo o cliente.
	
	// Todo relaciomaneot ToOne, sempre que a classe principal, neste caso Pedido, for usada, ele vai 
	// fazer um join com Cliente.
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	// Sempre que voce tem um relacionamento muitos pra muitos precisa de criar uma nova entidade 
	// para representar esta tabela.
	
	// No lado que tem o ToMany, temos que colocar (mappedBy = "pedido") e colocar o nome da atributo que
	// foi declarado na classe que esta com ManyToOne, ou seja, este eh o lado contrario de relacionamento 
	// referente a entidade ItemPedido.
	
	// Como eu estou fazendo um relacionamento bidirecional, Tanto pedido se relaciona com ItemPedido e vice-versa
	// entao se eu colocar que eu quero o cascade para persistir, que dizer que quando eu fazer um persist
	// na tabela atributo, faca uma persistencia na tabela ItemPedido tambem.
	
	// A anotacao OneToMany, temos um atributo chamado cascade, que vai persist ItemPedido quando Pedido for
	// persistido em banco de dados.
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Cliente cliente) {
		super();
		this.cliente = cliente;
	}
	
	// adicionar o itemPedido a lista de Pedido e setar a classe pedido em ItemPedido.
	public void adicionarPedido(ItemPedido itemPedido) {
		// O this, recebe a classe Pedido.java, ou seja, quando este metodo for instanciado, ele vai receber
		// a referencia da classe que o instanciou.
		
		// Na classe ItemPedido.java foi adicionado o Pedido.java
		itemPedido.setPedido(this);
		// E na classe Pedido.java foi adicionado o ItemPedido.java
		this.itens.add(itemPedido);
		// Adicionar ao valor total do pedido o resultado do preco unitario setado no momento em que o 
		// pedido foi feito pela quantiade de produtos.
		this.valorTotal = this.valorTotal.add(itemPedido.getValor());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
