package br.com.alura;

public class TestaBuscaAlunosNoCurso {

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
		
		System.out.println(curso.buscaMatriculado(323).getNome());
	}

}
