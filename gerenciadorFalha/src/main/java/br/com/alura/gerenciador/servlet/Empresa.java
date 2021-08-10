package br.com.alura.gerenciador.servlet;

public class Empresa {
	private Integer id;
	private String nome;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setNome(String nome) {
		// o atributo da intancia vai receber o nome do parametro.
		// Exemplo: se eu usar este metodo em uma classe main e passar o valor "matheus" como
		// parametro, quando eu usar o getNome vai me retornar "matheus"
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
