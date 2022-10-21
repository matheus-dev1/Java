package br.com.alura.jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
/* Se der este erro: Class "br.com.alura.jpa.model.ContaModel" is listed in the persistence.xml file, but is not annotated 
 * Va no seu arquivo persistence.xml, botão direito, Synchronize Class List. */
public class Conta {
	@Id
	// Obs: Se você criou uma tabela sem este modelo e depois colocou este @GeneratedValue(strategy = GenerationType.IDENTITY), 
	// vai dar erro, você tem que apagar e crir a tabela novamente.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer agencia;
	private Integer numero;
	private String titular;
	private Double saldo;
	// Relacionamento bidirecional
	/* Lazy Loading faz com que determinados objetos não sejam carregados do banco até que você precise
	 deles, ou seja, são carregados 'on demand' (apenas quando você solicitar explicitamente o
	 carregamento destes).

	Eager Loading carrega os dados mesmo que você não vá utilizá-los, mas é óbvio que você só utilizará
	esta técnica se de fato você for precisar com muita frequência dos dados carregados. */


	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)
	private List<Movimentacao> movimentacoes;

	public Conta() {
		super();
	}

	public Conta(Integer agencia, Integer numero, String titular, Double saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	@Override
	public String toString() {
		return "ContaModel{" +
				"id=" + id +
				", agencia=" + agencia +
				", numero=" + numero +
				", titular='" + titular + '\'' +
				", saldo=" + saldo +
				'}';
	}
}
