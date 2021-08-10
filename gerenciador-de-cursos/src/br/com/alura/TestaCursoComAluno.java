package br.com.alura;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class TestaCursoComAluno {

	public static void main(String[] args) {
		Curso curso = new Curso("Dominando as Colecoes do Java", "Paulo Silveira");
		
		curso.adiciona(new Aula("Revisitando as Spring", 55));
		curso.adiciona(new Aula("Revisitando as Colecoes", 15));
		curso.adiciona(new Aula("Revisitando as Java", 35));
		
		Aluno aluno1 = new Aluno("Matheus", 323);
		Aluno aluno2 = new Aluno("Joao", 656);
		Aluno aluno3 = new Aluno("Matheusdasdasdasdas", 566);
		
		curso.matricula(aluno1);
		curso.matricula(aluno2);
		curso.matricula(aluno3);
		
		curso.getAlunos().forEach(aluno -> System.out.println(aluno.getNome()));
		
		// Criando um conjunto com o metodo emptySet, fazendo com que ele nao possa colocar nada
		// A utilidade dele, imagine que um dia um curso nao pode mais receber matriculas.
		// voce pode usar este metodo para impedir que as matriculas sejam feitas neste curso.
		Set<String> nomes = Collections.emptySet();
		
		// nomes.add("Matheus");
		
		System.out.println(curso.estaMatriculado(aluno1));
		
		Aluno matheus = new Aluno("Matheus", 323);
		System.out.println(aluno1.equals(matheus));
		
		// Se dois objetos sao equals ele devem ter o mesmo hashcode...
		System.out.println(aluno1.hashCode() == matheus.hashCode());
		
		Set<Aluno> alunos = curso.getAlunos();
		
		// Toda as Colecoes/Collections tem um Iterador.
		Iterator<Aluno> iterador = alunos.iterator();
		
		// Vector<Aluno> vector = new Vector<>();
		
		// pergunta se tem algum algum proximo elementos? me retorna true ou false.
		while(iterador.hasNext()) {
			// Como essa foi true executeo next que me retorna o proximo elemento.
			Aluno proximo = iterador.next();
			System.out.println(proximo.getNome());
		}
	}

}
