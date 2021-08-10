package br.com.bytebank.banco.modelo;

import java.util.Comparator;

// Function Object - Uma classe para encapsular um unico metodo.
public class TitularDaContaComparator implements Comparator<Conta>{

	public int compare(Conta conta1, Conta conta2) {
		String contaCliente1 = conta1.getTitular().getNome();
		String contaCliente2 = conta2.getTitular().getNome();
		// O metodo compareTo da Classe String compara uma string com a outra a fim de buscar qual 
		// eh a "menor" em relacao ao alfabeto.
		System.out.println(contaCliente1);
		System.out.println(contaCliente2);
		return contaCliente1.compareTo(contaCliente2);
	}
	
}
