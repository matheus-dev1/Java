package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class InterfaceFuncionalImpl {
	public static void main(String[] args) {
		/* O metodo estatico "generate()" recebe como parametro uma interface funcional, que recebe um generics.
		 O parametro que metodo "generate()" precisa é chamado de "Fornecedor", isso porque ele recebe um
		 generics, mas nós não precisamos informar qual classe a ele, mas ele nos retorna a classe referente ao nosso retorno 
		 no nosso caso vai ser um Supplier<Integer> */
		Stream.generate(() -> new Random().nextInt()).limit(5).forEach(System.out::println);
		/*Diferente da interface "Fornecedor", essa interface é a "Consumidor" e ela reebe um parametro, no caso a nossa variavel "number",
		 * mas não nos retorna nada. */
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		numbers.forEach(number -> System.out.println(number));
		numbers.forEach(System.out::println);
		/*O BiConsumer a diferença é que ele recebe dois parametros em vez de 1 do "Consumidor" */
		BiConsumer<Integer, Integer> biConsumer = (number1, number2) -> System.out.println(number1 + " - " +  number2);
		// Usamos o accept como um "executor"
		// Obs: Aqui a gente não precisou implementar ele, porque ele já foi implementado na linha de cima.
		biConsumer.accept(1, 2);
		List<Integer> numbersPredicado = Arrays.asList(1, 2, 3, 4, 5);
		numbersPredicado.stream()
		// O Filter vai receber a implementação do Predicate, que recebe um valor como parametro e valida um hipotese(if).s
		.filter(number -> number % 2 == 0)
		// Aqui a gente consegue usar o Method Referece, porque a gente só tem um retorno.s
		.forEach(System.out::println);
		// O BiPredicate é a mesma coisa que o Predicate, mas ele é implementado recebendo dois parametros, que normalmente são testados entre si.
		BiPredicate<String, Integer> biPredicate = (palavra, tamanho) -> palavra.length() == tamanho;
		// Aqui eu vou testar se a String "teste" tem 5 caracteres.s
		boolean teste1 = biPredicate.test("teste", 5);
		System.out.println(teste1);
		boolean teste2 = biPredicate.test("testeErrado", 4);
		System.out.println(teste2);
		// A mehor maneira de exemplenficar isso é que eu posso passar um Integer como parametro e receber um Dooble como resposta, independente de como, eu entro
		// com um valor e saio com outro ou do mesmo tipo.
		List<Integer> numbersFunction = Arrays.asList(1, 2, 3, 4);
		System.out.println("-----------------------------------------------------");
		// Vou passar um inteiro e retornar um Doouble do mesmo valor.
		numbersFunction.stream().map(number -> number.doubleValue()).forEach(System.out::println);
		System.out.println("-----------------------------------------------------");
		numbersFunction.stream().map(number -> number + 2).forEach(System.out::println);
		// O BiFunction segue a mesma ideaia, eu recebo 3 parametros, sendo os dois primeros o valores usados para a logica e o terceiro o tipo de retorno.s
		BiFunction<Integer, Integer, Integer> biFunction = (number1, number2) -> number1 + number2;
		System.out.println("-----------------------------------------------------");	
		Integer inteiro1 = biFunction.apply(5, 5);
		System.out.println(inteiro1);
		System.out.println("-----------------------------------------------------");
		BiFunction<Integer, Integer, Double> biFunctionDouble = (number1, number2) -> Math.pow(number1, number2);
		Double double1 = biFunctionDouble.apply(2, 2);
		System.out.println(double1);
		System.out.println("-----------------------------------------------------");
		// UnaryOperator tem o mesmo comportamento que a Função(Interface Function), mas só funciona com os mesmos tipos.
		UnaryOperator<Integer> unaryOperator = number -> number + 4;
		UnaryOperator<Integer> unaryOperator2 = number -> number * 4;
		// BinaryOperator vai receber os dois parametros, fazer uma operação e retornar um valor, sendo todos(os dois parametros de entrada e o valor de saida tem
		// que ser do mesmo tipo)
		List<Integer> numbersBinaryOperator = Arrays.asList(1, 2, 3, 4);
		numbersBinaryOperator.stream().reduce((number1, number2) -> number1 + number2).ifPresent(System.out::println);
		System.out.println("-----------------------------------------------------");
		List<Integer> numbersAll = Arrays.asList(1, 2, 3, 4);
		numbersAll.stream()
				.filter(number -> number % 2 == 0)
				.map(number -> number.doubleValue())
				.reduce((number1, number2) -> number1 + number2)
				.ifPresent(System.out::println);
		System.out.println("-----------------------------------------------------");
		// As interfaces funcionais também aceitam Referência de Método
		numbersAll.stream()
			.filter(number -> number % 2 == 0)
			.map(Integer::doubleValue)
			.reduce(Double::sum)
			.ifPresent(System.out::println);
	}
}
