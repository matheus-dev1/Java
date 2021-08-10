package br.com.bytebank.banco.teste.util;

import java.util.List;


import java.util.ArrayList;

import java.util.Collections;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteComparatorSaldoColletionsOrdemNatural {
	public static void main(String[] args) {
		Conta contaCorrente1 = new ContaCorrente(22, 33);
		Conta contaCorrente2 = new ContaCorrente(22, 44);
		Conta contaCorrente3 = new ContaCorrente(22, 22);
		Conta contaCorrente4 = new ContaCorrente(22, 11);
		
        Cliente clienteContaCorrente1 = new Cliente();
        Cliente clienteContaCorrente2 = new Cliente();
        Cliente clienteContaCorrente3 = new Cliente();
        Cliente clienteContaCorrente4 = new Cliente();
        
        clienteContaCorrente1.setNome("a");
        clienteContaCorrente2.setNome("b");
        clienteContaCorrente4.setNome("d");
        clienteContaCorrente3.setNome("c");
       
        
        contaCorrente1.setTitular(clienteContaCorrente1);
        contaCorrente2.setTitular(clienteContaCorrente2);
        contaCorrente3.setTitular(clienteContaCorrente3);
        contaCorrente4.setTitular(clienteContaCorrente4);
        
        contaCorrente1.deposita(363.0);
        contaCorrente2.deposita(353.0);
        contaCorrente3.deposita(343.0);
        contaCorrente4.deposita(373.0);
		
		List<Conta> listaDeContas = new ArrayList<Conta>();
		
		listaDeContas.add(contaCorrente1);
		listaDeContas.add(contaCorrente2);
		listaDeContas.add(contaCorrente3);
		listaDeContas.add(contaCorrente4);
		
		for (Conta conta : listaDeContas) {
			System.out.print(conta + " Indice: ");
			System.out.println(listaDeContas.indexOf(conta));
		}
		
		System.out.println("-----------------------------------------------------");
		
		// Se passar null, ele compara com a Ordem Natural da classe.
		// listaDeContas.sort(null);
		
		// Vou ordernar a lista de objetos do tipo conta atraves da logica da Ordem natural definida 
		// na classe Conta.
		Collections.sort(listaDeContas);
		// Collections.reverse(listaDeContas);
		// Collections.shuffle(listaDeContas);
		// Collections.rotate(listaDeContas, 5);
		
		for (Conta conta : listaDeContas) {
			System.out.print(conta + " Indice: ");
			System.out.println(listaDeContas.indexOf(conta));
		}
	}
}
