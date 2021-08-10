package br.com.alura.lolja.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

// Tambem serve para chave composta e nao apenas para atributos em que eu quero separar da classe principal/mae
@Embeddable
public class CategoriaId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Chave composta, ou seja, estes dois atributos serao a minha chave primaria.
	private String nome;
	private String tipo;
	
	public CategoriaId() {
		super();
	}

	public CategoriaId(String nome, String tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
