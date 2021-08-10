package br.com.bytebank.banco.modelo;

import java.util.Comparator;

// O metodo .sort() da classe List/LinkedList/ArrayList solicita como parametro uma classe que implementa
// o metodo .compare() da interface Comparator().
// Obs: A interface Comparator() tem uma assinatura que obriga que a gente defina um <Generics>
// na implementacao da interface.
public class NumeroDaContaComparator implements Comparator<Conta>{
	// A ideia do metodo .compare() eh comparar se um objeto eh maior que o outro, isso nos temos
	// que implementar na nossa logica/regra de negocio.
	public int compare(Conta conta1, Conta conta2) {
		// Eu estou passando uma classe mais generica para poder usar ContaCorrente e ContaPoupanca independete
		// da posicao do argumento.
		if(conta1.getNumero() < conta2.getNumero()) {
			// ACHO!!! Se o numero da conta1 for menor que o numero da conta2 ele desce uma posicao.
			return -1;
		}
		if(conta1.getNumero() > conta2.getNumero()) {
			// Se o numero da conta1 for maior que o numero da conta2 ele sobe uma posicao, e ele vai fazendo
			// isso conta todos comparados com todos.
			// Exemplo se eu tenho 4 contas e eu tenho que testar para verificar qual e o maior numero
			// destas contas para o menor, eu tenho a possibilidade de 12 testes.
			// Quick Sort.
			return 1;
		}
		
		// return Integer.compare(conta1.getNumero(), conta2.getNumero());
		
		return 0;
	}
}
