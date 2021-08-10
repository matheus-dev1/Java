package br.com.alura.spring.data.orm;

public interface FuncionarioProjecao {
	// Projecao, eh como se voce simulasse um objeto, com apenas os valores que voce quer apresentar.

	// Para criar um projecao de uma entidade precisamos criar um interface com o mesmo nome da 
	// entidade + Projecao.

	// Para o SpringData entender eu tenho que criar metodo utilizando o mesmo nome dos atributos,
	// porem usando o prefixo get. Exemplo: String getNome();
	
	Integer getId();
	String getNome();
	Double getSalario();
}
