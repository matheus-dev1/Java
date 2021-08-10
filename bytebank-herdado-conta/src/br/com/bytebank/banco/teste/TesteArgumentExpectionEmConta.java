package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TesteArgumentExpectionEmConta {

	public static void main(String[] args) {
	//	try {
	//		Conta conta = new ContaCorrente(-2323, -343);
	//	} catch(IllegalArgumentException exception) {
	//		System.out.println("Agencia ou numero da conta invalido!");
	//	}
		
		try {
			Conta conta = new ContaCorrente(2323, 343);
		} catch(IllegalArgumentException exception) {
			System.out.println("Agencia ou numero da conta invalido!");
		} finally {
			System.out.println("FE com FE ");
		}
	}

}
