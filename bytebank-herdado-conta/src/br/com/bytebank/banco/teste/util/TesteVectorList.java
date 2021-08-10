package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.LinkedList;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteVectorList {
	public static void main(String[] args) {
		// O Vector internamente eh igual a um ArrayList, ou seja, internamente ele tambem usa um Array.
		// Um objeto Vector eh um Thread Safe.
		// Um mesmo objeto Vector pode ser manipulado atraves de varias pilhas em execucao.
		// Duas listas que trabalham simultaneamente referente ao um unico objeto Vector.
		// Obs: Um objeto Vector eh mais custoso, ele exige mais recusos, mais desempenho/processamento...
		LinkedList<Conta> lista = new LinkedList<Conta>();

		ContaCorrente contaCorrente = new ContaCorrente(232, 6767);
		ContaPoupanca contaPoupanca = new ContaPoupanca(656, 7778);
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(656, 7778);
		
		lista.add(contaCorrente);
		lista.add(contaPoupanca);
		
		System.out.println(lista.contains(contaPoupanca));
		
		for(Conta indiceDaReferencia : lista) {
			System.out.println(indiceDaReferencia);
		}
		
		for(Conta indiceDaReferencia : lista) {
			System.out.println(indiceDaReferencia == contaCorrente);
		}
		
		System.out.println("-----------------------------");
		
		boolean aa = contaPoupanca.equals(contaPoupanca2);
		if(aa) {
			System.out.println("Agencia e Numero da conta igual");
		} else {
			System.out.println("Agencia ou numer da conta diferentes");
		}
	}

}
