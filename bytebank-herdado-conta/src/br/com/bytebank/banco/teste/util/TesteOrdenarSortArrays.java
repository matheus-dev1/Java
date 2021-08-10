package br.com.bytebank.banco.teste.util;

import java.util.Arrays;

public class TesteOrdenarSortArrays {

	public static void main(String[] args) {
		int[] numeros = new int[10];
		
		numeros[0] = 999;
		System.out.println(numeros[0]);
		
		for(int index = 1; index < numeros.length; index++) {
			numeros[index] = index;
			System.out.println(numeros[index]);
		}
		
		System.out.println("-------------");
		
		Arrays.sort(numeros);

		for(int index = 0; index < numeros.length; index++) {
			System.out.println(numeros[index]);
		}
	}

}
