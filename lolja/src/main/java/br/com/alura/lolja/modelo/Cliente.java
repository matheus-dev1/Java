package br.com.alura.lolja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// private String nome;
	// private String cpf;
	@Embedded
	private DadosPessoais dadosPessoais;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf) {
		super();
		// this.nome = nome;
		// this.cpf = cpf;
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}
	
	// Metodo Delegate, basicamente eu do um nome pra uma funcao que ja existe pelo fato dela estar 
	// sendo usada em varios pontos da aplicacao.
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
	
	public String getCpf() {
		return this.dadosPessoais.getCpf();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/*public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}*/

	/*public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}*/
	
	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
}
