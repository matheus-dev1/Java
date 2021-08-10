package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.LinkedList;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteLinkedList {
	public static void main(String[] args) {
		
		// Lista duplamente encadeada - Sua vantagem eh que, todo elemento sabe a posicao do elemento anterior
		// e do elemento sucessor, fazendo com eles se referenciem.
		// Porem para voce acessar um elemento, voce nao consegue fazer isso diretamente, voce precisa de
		// uma logica e passar por todos os elementos ate encontrar o que voce deseja.
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
		
		// Verifica se a referencia em determinada posicao e igual a referencia de comparacao.
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
