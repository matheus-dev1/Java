package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteAutoboxing {
	public static void main(String[] args) {
		int a = 44;
		
		// As listas apenas aceitam Objetos, e nao tipos primitivos.
		// Mas se por exemplo voce passar um tipo primitivo para um metodo do Objeto List/LinkedList/ArrayList
		// entre outros ele vai fazer a conversao para o objeto do tipo que era primitivo e
		// essa conversao se chama Autoboxing.
		// Exemplo: lista.add(45); // A conversao sera feita, e 45 vira um objeto do tipo Interger.
		
		List lista = new ArrayList();
		
		// Deprecated significa que algo esta desatualizado e deve/tem algo melhor para ser usado.
		Integer integer = new Integer(44);
		
		// Variáveis e métodos marcados como static pertencem à classe, ao invés de a alguma instância particular
		Integer integerReferencia = integer.valueOf(65);
		
		// Unboxing eh quando nos fazemos a conversao de um objeto para o seu tipo primitivo, tipo um objeto do
		// tipo Integer para int.
		// Wrapper eh o nome dado para uma classe referente a um tipo primitivo, e eles existem para todos
		// os tipos primitivos. Exemplo: Integer -> int.
		// Unboxing.
		int valorUnboxing = integerReferencia.intValue();
		
		System.out.println(integerReferencia);
		
		// Autoboxing.
		lista.add(a);
		
		//Parsing - Tranformando um objeto String com o valor de "10" para 10 do tipo Objeto Integer.
		Integer numero = Integer.valueOf("10");
		
		// Integer para String!
		String stringNumber = String.valueOf(1000);
		
		System.out.println(stringNumber);
		
		// String para int primitivo.
		int numberPrimitive = Integer.parseInt("999");
	}
}
