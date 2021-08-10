package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayDeReferencias {

	public static void main(String[] args) {
		// Um array também é um objeto!
		
		// Aqui nos apenas criamos um objeto que representa um array de 5 pisicoes, mas nao instanciamos nada
		// uma prova disso eh que nao usamos as chaves para passar os parametros necessarios do construtor
		// desta classe. Por padrao elas vem como "null".
		ContaCorrente[] contasCorrente = new ContaCorrente[5];
		// System.out.println(contasCorrente[1].getClass());
		for(int index = 0; index < contasCorrente.length; index++) {
			contasCorrente[index] = new ContaCorrente(index + 2, index + 43);
			System.out.println(contasCorrente[index]);
			System.out.println("-------------------------------------");
		}
		
		// Declarando Array de forma literal, desta forma eu ja sei que tem 4 possicoes e em cada posicao
		// eu ja estou definindo um valor
		int[] arrayLiteral = {1,34,555,4566,878};
		System.out.println(arrayLiteral[1]);
	}
}
