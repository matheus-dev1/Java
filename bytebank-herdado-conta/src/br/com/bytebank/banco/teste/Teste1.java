package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class Teste1 {

	public static void main(String[] args) {
		GuardadorDeReferencias guardadorDeReferencias = new GuardadorDeReferencias();
		
		Cliente cliente = new Cliente();
		ContaCorrente contaCorrente = new ContaCorrente(232, 6767);
		ContaPoupanca contaPoupanca = new ContaPoupanca(656, 7778);
		
		guardadorDeReferencias.adiciona(cliente);
		guardadorDeReferencias.adiciona(contaPoupanca);
		guardadorDeReferencias.adiciona(contaCorrente);
		
		System.out.println(guardadorDeReferencias.getReferencia(0));
		System.out.println(guardadorDeReferencias.getReferencia(1));
		System.out.println(guardadorDeReferencias.getReferencia(2));
		
		// Me retorna uma referencia do tipo Object, usando o Type Casting nos covertemos para Conta
		// Porque Conta eh um Object.
		Conta referenciaConta = (Conta) guardadorDeReferencias.getReferencia(1);
		
		System.out.println(referenciaConta.getNumero());
		System.out.println(referenciaConta.getAgencia());
		
		// Se tentarmos usar uma classe que nao existe, ele vai nos sugerir criar.
		System.out.println(guardadorDeReferencias.getQtdElementos());
	}

}
