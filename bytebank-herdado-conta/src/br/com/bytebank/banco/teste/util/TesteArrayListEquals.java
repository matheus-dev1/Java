package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayListEquals {
	public static void main(String[] args) {
		
		// O problema deste tipo de lista, eh em relacao a desempenho, porque vamos supor que voce tenha
		// 100 indices em um array e voce quer remover o indice 57, o array vamo se organizar(gastar desempenho)
		// para os elementos depois de 57 se arranjarem e ficarem com um indice de 99.
		ArrayList<Conta> lista = new ArrayList<Conta>();

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
