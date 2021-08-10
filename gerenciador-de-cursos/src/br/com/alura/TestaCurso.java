package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		Curso curso = new Curso("Dominando as Colecoes do Java", "Paulo Silveira");
		
		// curso.getAulas().add(new Aula("Revisitando as Colecoes", 33));
		
		curso.adiciona(new Aula("Revisitando as Spring", 55));
		curso.adiciona(new Aula("Revisitando as Colecoes", 15));
		curso.adiciona(new Aula("Revisitando as Java", 35));
		
		// Statement | Comando em que eu dei...
		List<Aula> aulas = curso.getAulas();
		
		System.out.println(aulas);
		
		// aulas.add(new Aula("Revisitando as ArrayLists", 21));
		
		System.out.println(aulas);
		
		System.out.println(curso.getAulas());
		
		// Vou instanciar um novo array list com um "clone" das minhas aulas que eram imutaveis 
		// e agora sao mutaveis.
		List<Aula> aulasMutaveis = new ArrayList<>(aulas);
		
		Collections.sort(aulasMutaveis);
		
		System.out.println(aulasMutaveis);
		
		System.out.println(curso.getTempoTotal() + " minutos!");
	}

}
