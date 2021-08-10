package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAula {

	public static void main(String[] args) {
		Aula aula1 = new Aula("Revisitando as ArrayLists", 21);
		Aula aula2 = new Aula("Listas de Objectos", 19);
		Aula aula3 = new Aula("Relacionamento de Listas e Objetos", 17);
		
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas); // Sem ordenar
		
		Collections.sort(aulas);
		
		System.out.println(aulas); // Ordenado pelo titulo
		
		// Ordena as aulas comparando todos os tempos das aulas retirados do metodo getTempo()
		// mas nao o invocando.
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		
		System.out.println(aulas); // Ordenado pelo tempo.
		
		// Poderia fazer tambem.
		// aulas.sort(Comparator.comparing(Aula::getTempo));
	}

}
