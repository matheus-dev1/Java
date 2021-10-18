package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Cursos {
    private String nome;
    private int alunos;

    public Cursos(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class Curso {
	public static void main(String[] args) {
		List<Cursos> cursos = new ArrayList<Cursos>();
		cursos.add(new Cursos("Python", 45));
		cursos.add(new Cursos("JavaScript", 150));
		cursos.add(new Cursos("Java 8", 113));
		cursos.add(new Cursos("C", 55));
		
		// Comparação pelo valor da quantidade de alunos.
		cursos.sort(Comparator.comparing(Cursos::getAlunos));
		
		// cursos.forEach(System.out::println);
		
		// cursos.forEach(c -> System.out.println(c.getNome()));
		
		// O Stream devolvido por esse método tem uma dezena de métodos bastante úteis.
		// O primeiro é o filter, que recebe um predicado (um critério), que deve
		// devolver verdadeiro ou falso, dependendo se você deseja filtrá-lo ou não.
		// Obs: o Stream não impacta na colletion original.
		
		/*
		 * Interface Fluida / Fluent Interface
		 * É uma forma de nomear métodos para serem usados em uma construção que dê a impressão de estar
		 * escrevendo um texto corrente, fluido.
		 * Ele desiste de uma nomenclatura comum e padronizada para adotar algo que faça sentido 
		 * quando o método for usado tentando simular um texto fluente em língua humana.
		 * É uma forma de deixar o código mais declarativo.
		 * 
		 * MailMessage.builder()
		 * .from("eu@dominio.com")
		 * .to("voce@dominio.com.br")
		 * .subject("oi")
		 * .message("Oi pra vc")
		 * .send();
		 */
		
		cursos
			.stream()
			// FAz um filtro apenas dos cursos com 100 alunos
			.filter(c -> (c.getAlunos() >= 100))
			// Pega o objeto de cada Curso
			.map(c -> c.getAlunos())
			// Cada interação vai simbolizar(um objeto do tipo Integer) a quantidade de alunos 
			// deste curso, ou seja, cada interação de "total" é um Integer e não um Curso
			// class java.lang.Integer
			.forEach(total -> System.out.println(total));
		
		// filter.forEach(c -> System.out.println(c.getAlunos()));
		
		/*
		 * Optional é uma importante nova classe do Java 8. É com ele que poderemos trabalhar de
		 * uma maneira mais organizada com possíveis valores null. Em vez de ficar comparando
		 * if(algumaCoisa == null), o Optional já fornece uma série de métodos para nos ajudar
		 * nessas situações.
		 * */
		
		/*
		 * O método Collect recebe um Collector, uma interface não tão trivial de se implementar.
		 * Podemos usar a classe Collectors (repare o s no final), cheio de factory methods
		 * (método que cria metodo ou que possui metodo dentro, exemplo do collect() que possui
		 * o Collectors, onde dentro do Colletors possui varios metodo que retorna um objeto
		 * de determinado tipo como por exemplo a conversão de um objeto Stream<Curso> para List<Curso>)
		 * que ajudam na criação de coletores. Um dos coletores mais utilizados é o retornado
		 * por Collectors.toList();
		 * */
		
		System.out.println("---------------------------------------");
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny()
		   .ifPresent(c -> System.out.println(c));
		
		System.out.println("---------------------------------------");
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst()
		   .ifPresent(c -> System.out.println(c));
		
		System.out.println("---------------------------------------");
		
		cursos.stream()
			.mapToInt(c -> c.getAlunos())
			.average()
			.stream()
			.forEach(c -> System.out.println(c));
		
		System.out.println("---------------------------------------");
		
		cursos = cursos.stream()
				   .filter(c -> c.getAlunos() > 50)
				   .collect(Collectors.toList());
		
		cursos.stream().forEach(c -> System.out.println(c.getAlunos()));
		
		System.out.println("---------------------------------------");
		
	}
}