package br.com.alura;

public class Aluno {
	private String cpf;
	private String nome;
	private Integer matricula;
	
	public Aluno(String nome, Integer matricula) {
		if(nome == null) {
			throw new NullPointerException("Nao pode ser null!");
		}
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getMatricula() {
		return matricula;
	}
	
	// Sempre que equals eh sobreescrito hashcode tambem devera.
	@Override
	public boolean equals(Object obj) {
		Aluno outro = (Aluno) obj;
		return this.nome.equals(outro.nome);
	}
	
	@Override
	public int hashCode() {
		// Vai retonar em forma de char(numero) da primeira letra de cada aluno.
		// return this.nome.charAt(0);
		return this.nome.hashCode();
	}
}
