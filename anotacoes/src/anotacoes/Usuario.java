package anotacoes;

import java.time.LocalDate;

public class Usuario {
	private String nome;
	private String cpf;
	// Configuramos aqui que a idade minina que este atributo pode receber é 18
	@IdadeMinima(valor=18)
	private LocalDate dataNascimento;
	   
	public Usuario(String nome, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
}