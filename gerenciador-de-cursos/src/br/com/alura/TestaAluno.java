package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestaAluno {

	public static void main(String[] args) {
		// Conjunto / Set(HashSet) | Voce nao sabe a ordem em que estes objetos vao ficar dentro deste
		// amontuado de objetos.
		// Nao aceita elementos repitidos.
		// Velociade e performance!
		// Set<String> alunos = new HashSet<>();
		// Tabela de Espalhamento
		//O HashSet define um numero identificador(HashCode) para varios grupos dentro de HashSet.
		Collection<String> alunos = new HashSet<>();
		
		alunos.add("Matheus");
		alunos.add("Math");
		alunos.add("Nico Steppat");
		alunos.add("Ricardo");
		alunos.add("Nico asdasd");
		
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		
		System.out.println("---------------------------------------------");
		
		alunos.forEach((aluno) -> System.out.println(aluno));
		System.out.println(alunos);
	
		System.out.println(alunos.contains("Math"));
		
		// Eh comum trabalhar com varias colecoes ao mesmo tempo para aproveitas as vantagens
		// de cada lista.
		// Eu posso passar qualquer objeto que seja mae de List, no caso uma Collection
		List<String> alunosEmLista = new ArrayList<String>(alunos);
		
		System.out.println(alunosEmLista.get(1));
	}

}
