package br.com.bytebank.banco.teste.util;

import java.util.Arrays;

import java.util.List;

public class TesteArrayIntoList {

	public static void main(String[] args) {
		// Basicamente nos pegamos o array do metodo main e tranformamos em uma lista do tipo String, fazendo
		// isso ele recebe todos os metodo e atrubutos da 
		List<String> argumentos = Arrays.asList(args);
		
		System.out.println(argumentos.get(1));
	}

}
