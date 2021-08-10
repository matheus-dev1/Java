package br.com.bytebank.banco.teste;

public class TesteArray {

	public static void main(String[] args) {
		// Array
		// int array [];
		int [] array;
		
		// Array eh um objeto, e nos precisamos instancia-los, colocando o tipo do array, colchestes e a quanti-
		// dade de posicoes, sendo que ele comeca em 0 e os valores padrao do tipo inteiro tambem eh 0.
		int[] arrayInstanciado = new int[4];

		System.out.println(arrayInstanciado[0]);
		System.out.println(arrayInstanciado.length);
		
		for(int index = 0; index < arrayInstanciado.length; index++) {
			arrayInstanciado[index] = index;
			System.out.println(arrayInstanciado[index]);
		}
	}

}
