package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayList {
	
	// Ao criar uma classe, no pacote voce pode colocar mais um sub pacote que o Eclipse cria pra voce, junto
	// com a classe.
	public static void main(String[] args) {
		// Por padrao, ele vai nos dar 1000 posicoes.
		// O limite de array eh a memoria do Java Virtual Machine(JVM)
		
		// Lista de referencias do tipo Object, ou seja, este arraylist apenas tera referencias deste tipo.
		// Generics Java Array - Parametrizar <>!
		// Obs: So pode colocar classes, nao tipos primitivos comos inteiro, double e etc...
		ArrayList<Object> lista = new ArrayList<Object>();
		
		// Nos podemos definir um ArrayList com um tamanho predefinido. 
		// Exemplo: ArrayList arrayDefinido = new ArrayList(25);
		
		// Podemos tambem criar uma lista baseada em outra lista
		// Exemplo ArrayList novaLista = new ArrayList(arrayDefinido);
		
		Cliente cliente = new Cliente();
		ContaCorrente contaCorrente = new ContaCorrente(232, 6767);
		ContaPoupanca contaPoupanca = new ContaPoupanca(656, 7778);
		
		
		lista.add(contaCorrente);
		lista.add(contaPoupanca);
		lista.add(cliente);
		
		// Object contaCorrenteRef = lista.get(2);
		Object contaCorrenteRef = (Object) lista.get(2);
		
		System.out.println(contaCorrenteRef);
		
		System.out.println(lista.size());
		System.out.println(lista.get(0));
		System.out.println(lista.get(1));
		System.out.println(lista.get(2));
		 
		lista.remove(0);
		
		System.out.println(lista.size());
		
		System.out.println("----------------------------------------");
		
		// Semelhante ao ForEach, basicamente este laco vai passar por cada indece do meu Array.
		for(Object indiceDaReferencia : lista) {
			System.out.println(indiceDaReferencia);
		}
	}

}
