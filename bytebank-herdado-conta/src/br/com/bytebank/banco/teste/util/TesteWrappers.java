package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrappers {

	public static void main(String[] args) {
		Integer a = 3;
		Double b = 3.3;
		Character c = 'c';
		Boolean d = Boolean.FALSE;
		System.out.println(d);
		
		// Clase mae de todos os objetos do tipo numericos. class Number.
		// Um exeplo de utilizacao, eu por exemplo poderia armazenar uma lista/array um objeto do tipo numero
		// onde eu poderia armazrnar qualquer objeto numero, exemplo Integer, Double, Float entre outros.
		Number number = Integer.valueOf(10);
		System.out.println(number.floatValue());
		
		List<Number> listaNumbers = new ArrayList();
		
		listaNumbers.add(1);
		listaNumbers.add(4.12);
		listaNumbers.add(14.3f);
	}

}
