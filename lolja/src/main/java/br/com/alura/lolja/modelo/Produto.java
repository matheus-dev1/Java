package br.com.alura.lolja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

// public @interface Entity - Exemplo anotacao. - E eu nao importei a do hibernate porque eu quero a menor
// aclopacao a biblioteca hibernate que vai implementar as interfaces do JPA.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// Com esta anotacao eu estou definindo e dizendo para o compilador que esta classe eh uma tabela
// no banco de dados.
// E tem que adicionar uma tag class no persistence.xml a clasee.
// Exemplo: <class>br.com.alura.lolja.modelo.Produto</class> | Obs: isso eh algo do hibernate
@Entity

// Por padrao o JPA considera o nome da entidade igual a da tabela em banco de dados.
// Porem com a anotacao Table podemos configurar o real nome da tabela.
@Table(name = "produtos")

// Query na propria entidade.
@NamedQuery(name = "Produto.produtosPorCategoria", query = "SELECT produt FROM Produto AS produt WHERE produt.categoria.id.nome = :nome")

// Para utilizar a estrategia Single Table, vamo na classe mae, no caso esta aqui e colocamos esta anotacao
// Obs: Tem que colocar @Entity nas tabelas que herdam de produto.
// Ele vai criar tambem uma coluna chamda DTYPE para identificar qual o objeto.
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)

// Ele sempre vai fazer um join usando esta estrategia.
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	// Definir qual id da tabela e quem gera o id.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Por padrao tambem o JPA sabe que os meus atributos sao os nomes exatamente iguais a do meu 
	// banco de dados. 
	// Porem eu tenho uma anotacao que eu posso definir qual eh o nome da coluna em banco de dados.
	// @Column(name = "name")
	private String nome;
	
	private String descricao;
	
	private BigDecimal preco;
	
	// Pegar a data do instanciamento da classe.
	private LocalDate dataCadastro = LocalDate.now();
	
	// Vai cadatras o nome da constrate no BD, e nao a posicao.
	// @Enumerated(EnumType.STRING)
	// private CategoriaEnum categoria;
	
	// Um produto apenas tem uma categoria, mas uma categoria pode estar vinculado a varios produtos.
	// Aqui eu defino que muitos produtos estao vinculados a uma categoria.
	@ManyToOne
	private Categoria categoria;
	
	public Produto() {
		
	}
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
