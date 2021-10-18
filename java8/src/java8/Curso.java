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
		
		// Compara��o pelo valor da quantidade de alunos.
		cursos.sort(Comparator.comparing(Cursos::getAlunos));
		
		// cursos.forEach(System.out::println);
		
		// cursos.forEach(c -> System.out.println(c.getNome()));
		
		// O Stream devolvido por esse m�todo tem uma dezena de m�todos bastante �teis.
		// O primeiro � o filter, que recebe um predicado (um crit�rio), que deve
		// devolver verdadeiro ou falso, dependendo se voc� deseja filtr�-lo ou n�o.
		// Obs: o Stream n�o impacta na colletion original.
		
		/*
		 * Interface Fluida / Fluent Interface
		 * � uma forma de nomear m�todos para serem usados em uma constru��o que d� a impress�o de estar
		 * escrevendo um texto corrente, fluido.
		 * Ele desiste de uma nomenclatura comum e padronizada para adotar algo que fa�a sentido 
		 * quando o m�todo for usado tentando simular um texto fluente em l�ngua humana.
		 * � uma forma de deixar o c�digo mais declarativo.
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
			// Cada intera��o vai simbolizar(um objeto do tipo Integer) a quantidade de alunos 
			// deste curso, ou seja, cada intera��o de "total" � um Integer e n�o um Curso
			// class java.lang.Integer
			.forEach(total -> System.out.println(total));
		
		// filter.forEach(c -> System.out.println(c.getAlunos()));
		
		/*
		 * Optional � uma importante nova classe do Java 8. � com ele que poderemos trabalhar de
		 * uma maneira mais organizada com poss�veis valores null. Em vez de ficar comparando
		 * if(algumaCoisa == null), o Optional j� fornece uma s�rie de m�todos para nos ajudar
		 * nessas situa��es.
		 * */
		
		/*
		 * O m�todo Collect recebe um Collector, uma interface n�o t�o trivial de se implementar.
		 * Podemos usar a classe Collectors (repare o s no final), cheio de factory methods
		 * (m�todo que cria metodo ou que possui metodo dentro, exemplo do collect() que possui
		 * o Collectors, onde dentro do Colletors possui varios metodo que retorna um objeto
		 * de determinado tipo como por exemplo a convers�o de um objeto Stream<Curso> para List<Curso>)
		 * que ajudam na cria��o de coletores. Um dos coletores mais utilizados � o retornado
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