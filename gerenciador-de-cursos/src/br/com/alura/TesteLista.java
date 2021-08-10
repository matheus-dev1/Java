package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TesteLista {

	public static void main(String[] args) {
		String aula1 = "Aula1";
		String aula2 = "Aula2";
		String aula3 = "Aula3";
		
		ArrayList<String> aulas = new ArrayList<>();
		
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas);
		
		aulas.remove(0);
		
		System.out.println(aulas);
		
		for (String aula : aulas) {
			System.out.println(aula);
		}
		
		System.out.println("primeira aula: " + aulas.get(0));
		
		System.out.println("-----------------------------------");
		
		for (Iterator iterator = aulas.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		System.out.println("-----------------------------------");
		
		aulas.forEach((aula) -> System.out.println(aula));
		
		System.out.println("-----------------------------------");
		
		aulas.add(aula1);
		
		aulas.forEach((aula) -> System.out.println(aula));
		
		System.out.println("-----------------------------------");
		
		Collections.sort(aulas);
		
		aulas.forEach((aula) -> System.out.println(aula));
	}

}
