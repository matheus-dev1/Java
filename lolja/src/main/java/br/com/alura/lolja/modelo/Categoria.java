package br.com.alura.lolja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	*/
	
	// Defino que dentro desta classe estao os atributos que formao a chave primaria desta entidade.
	@EmbeddedId
	private CategoriaId id;
	
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		super();
		// this.nome = nome;
		this.id = new CategoriaId(nome, "Categoria Default");
	}

	public String getNome() {
		// return nome;
		return this.id.getNome();
	}
	public void setNome(String nome) {
		// this.nome = nome;
		this.id.setNome(nome);
	}
}
