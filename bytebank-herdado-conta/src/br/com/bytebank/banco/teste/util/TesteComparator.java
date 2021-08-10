package br.com.bytebank.banco.teste.util;

import java.util.List;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.NumeroDaContaComparator;

public class TesteComparator {
	public static void main(String[] args) {
		// CTRL + SHIFT + O | Importa todas as classes.
		// CTRL + SHIFT + T | Abre uma caixa com um textInput para pesquisar classes.
		ContaCorrente contaCorrente = new ContaCorrente(232, 999);
		ContaPoupanca contaPoupanca = new ContaPoupanca(656, 7778);
		ContaCorrente contaCorrente2 = new ContaCorrente(23345, 888);
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(654566, 465778);
		
		contaCorrente.deposita(234);
		contaCorrente2.deposita(48778);
		contaPoupanca.deposita(8896);
		contaCorrente2.deposita(5467);
		
		List<Conta> listaDeContas = new ArrayList<Conta>();
		
		listaDeContas.add(contaCorrente);
		listaDeContas.add(contaPoupanca);
		listaDeContas.add(contaCorrente2);
		listaDeContas.add(contaPoupanca2);
		
		// Antes da ordenacao do menor para o maior
		for (Conta conta : listaDeContas) {
			System.out.print(conta + " Indice: ");
			System.out.println(listaDeContas.indexOf(conta));
		}
		
		System.out.println("----------------------------");
		
		NumeroDaContaComparator numeroDaContaComparator = new NumeroDaContaComparator();
		
		// Os motivos do porque eu nao invoco o metodo eh o seguinte, se nos passasemos o metodo, eu 
		// estaria enviado apenas duas referencias e ai ja esta errado.
		// Entao eu passando apenas a classe, o metodo .sort() fica responsavel por invocar o metodo
		// .compare() e ir testando todos os objetos.
		listaDeContas.sort(numeroDaContaComparator);
		
		// Depois da ordenacao do maior para o menor
		for (Conta conta : listaDeContas) {
			System.out.print(conta + " Indice: ");
			System.out.println(listaDeContas.indexOf(conta));
		}
	}
}
