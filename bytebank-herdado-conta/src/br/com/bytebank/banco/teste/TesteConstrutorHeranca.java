package br.com.bytebank.banco.teste;

// Por padrao, para nao houver a possibilidade de repeticao de nome de projeto, nos usamos
// uma hierarquia de pastas/packages especifica. 
// Exemplo com package: br.com.bytebank.banco.modelo ou br.com.bytebank.banco.teste
// Exemplo com pastas: br/com/bytebank/banco/modelo ou br/com/bytebank/banco/teste

// * no final do import significa todas as classes.
import br.com.bytebank.banco.modelo.*;

public class TesteConstrutorHeranca {
	public static void main(String[] args) {
		// Usando a estrutura CamelCase, Se voce por colocar apenas as letras maiusuclas de alguma coisa,
		// ele ja vai te sugerir um autopreenchimento daquilo.
		// Exemplo CC vai me sugerir um autocomplete de ContaCorrente
		ContaCorrente contaCorrente = new ContaCorrente(23323, 76767);
		Conta conta = new ContaCorrente(66664, 34344);
	}
}
