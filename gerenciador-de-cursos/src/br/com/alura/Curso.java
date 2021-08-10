package br.com.alura;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class Curso {
	private String nome;
	private String instrutor;
	
	// Quanto menos voce se compromete com um objeto eh melhor, voce por exemplo poderia
	// criar um atributo do tipo List<> que pode ser tanto do LinkedList como um ArrayList,
	// voce abrangem as suas posibilidades sem perder nada. E nao importa qual tipo de 
	// lista ela o atributo eh, por que ele vai tratar a lista de qualquer forma.
	
	// Uma lista de objetos do tipo Aula.
	
	// Linked list sao listas linkada umas nas outras, boas em deletar items 
	// e colocar elementos em qualquer posicao.
	// ArrayList usa por baixo dos panos um array, buscar uma informacao de forma muito mais precisa
	private List<Aula> aulas = new LinkedList<Aula>();
	// Uma collection e todo mundo que implementa a interface collection
	private Set<Aluno> alunos = new HashSet<>();
	
	// A ideferenca eh que a colecao fica na ordem de objetos adicionada a "alunos" 
	// private Set<Aluno> alunos = new LinkedHashSet<>();
	
	// Arvore rubro negra | Ele vai guardar tudo ordenado na ordem natural dos objetos, ou seja,
	// na ordem da interaface comparable ou comparator.
	// private Set<Aluno> alunos = new TreeSet<>();
	
	// Ele vai mapear atraves de um numero do tipo inteiro um aluno corresponte, onde o numero
	// eh a matricula dele. | Tablea de Espalhamento.
	// private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	
	// A diferenca do LinkedHashMap para o HashMap eh que Linked salva os put() de forma ordenada.
	private Map<Integer, Aluno> matriculaParaAluno = new LinkedHashMap<>();
	
	// private Map<Integer, Set<Aluno>> matriculaDeAlunos;
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getInstrutor() {
		return instrutor;
	}
	
	// Me retorna uma Lista do tipo Aula.
	public List<Aula> getAulas() {
		// Ele me retona a minha lista mas de uma maneira em que ela outros objetos 
		// nao pode ser alterada, apenas o da propria classe.
		
		// Sempre programe defensivamente, quando devolver referencias para objetos, 
		// devolver uma copia ou algo imutavel.
		return Collections.unmodifiableList(aulas);
	}
	
	// Uma boa pratica eh definir que o unico objeto que pode alterar um objeto eh ele mesmo.
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public Integer getTempoTotal() {
		Integer tempoTotal = 0;
		for (Aula aula : aulas) {
			tempoTotal += aula.getTempo();
		}
		return tempoTotal;
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		// Aqui eu estou definindo que determinado objeto eh representado pelo numero de 
		// aluno.getMatricula().
		matriculaParaAluno.put(aluno.getMatricula(), aluno);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatriculado(Integer NumeroMatricula) {
		// Ao passar o numero de matricula ele me retorna o objeto aluno associado a ele.
		return matriculaParaAluno.get(NumeroMatricula);
		// for(Aluno aluno : alunos) {
			// if(aluno.getMatricula() == NumeroMatricula) {
				// return aluno;
			// }
		// }
		// throw new NoSuchElementException("Matricula nao encontrada.");
	}
}
