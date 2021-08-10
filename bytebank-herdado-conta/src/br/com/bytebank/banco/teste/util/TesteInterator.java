package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TesteInterator {

	public static void main(String[] args) {
		List<String> nomes = new ArrayList<String>();
		
		nomes.add("Matheus");
		nomes.add("Joao");
		nomes.add("Cesar");
		nomes.add("Domingos");
		
		// Uma interface "Iterator" eh um objeto que possuio no minimo dois metodos: hasNext() e
		// next();. Ou seja, voce pode usa-lo para perguntar se existe um proximo elemento e pedir
		// o proximo elemento. A noticia boa e que isso funciona com TODAS as implementacoes.
		Iterator<String> element = nomes.iterator();
		
		// Metodo hasNext() pergunta se tem outro elemento.
		while(element.hasNext()) {
			// Se tiver ele executa o metodo next para retornar o proximo.
			System.out.println(element.next());
		}
	}
}
