package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("ccc");
		palavras.add("a");
		palavras.add("bb");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		
		// Collections.sort(palavras); - Comparador padrão
		// Collections.sort(palavras, comparador); - Comparador nosso.
		// Metodo da propria lista de ordenação com o parametro de ordenação por tamanho da string.
		
		/*
		 * É um default method! Um método de interface que você não precisa implementar
		 * na sua classe se não quiser, pois você terá já essa implementação default.
		 * Default Methods - adicionar métodos em interfaces e implementá-los ali mesmo! 
		 */
		
		palavras.sort(comparador);
		
		System.out.println("---------------------------------------");
		
		System.out.println(palavras);
		
		for (String p : palavras) {
			System.out.println(p);
		}
		
		Consumer<String> consumidor = new ImprimeNaLinha();
		
		// Classe/interface anonima - Eu não preciso declarar uma classe e escrever o seu metodo,
		// eu posso diretamente ja escrever e depois instancia, eu posso já instanciar implementando
		// o metodo.
		
		// São as chamadas classes anônimas, que usamos com frequência para implementar 
		// listeners e callbacks que não terão reaproveitamento.
		
		System.out.println("---------------------------------------");
		
		palavras.forEach(new Consumer<String>() {
			@Override
		    public void accept(String s) {
		        System.out.println(s);
		    }
		});
		
		System.out.println("---------------------------------------");
		
		palavras.forEach(consumidor);
		/* Tendo essas dificuldade e verbosidade da sintaxe das classes anônimas em vista, o
		 * Java 8 traz uma nova forma de implementar essas interfaces ainda mais sucinta.
		 * É a sintaxe do lambda. Em vez de escrever a classe anônima, deixamos de escrever
		 * alguns itens que podem ser inferidos.
		 * Como essa interface só tem um método, não precisamos escrever o nome do método. 
		 * Também não daremos new. Apenas declararemos os argumentos e o bloco a ser executado,
		 * separados por "->"
		 */
		
		System.out.println("---------------------------------------");
		
		// O java vai saber que o forEach recebe consumer, ele vai tentar atribuir o valor do parametro
		// dentro de forEach escrito desta maneira para dentro do consumer
		// Obs: Esse codigo: "s -> System.out.println(s)" é equivalentea toda a classe "ImprimeNaLinha"
		palavras.forEach(s -> System.out.println(s));
		
		System.out.println("---------------------------------------");
		
		// O lambda funciona sempre que você tem apenas um metodo abstrato, ou seja,
		// uma interface funcional
		
		palavras.sort((s1, s2) -> {
			if(s1.length() < s2.length()) {
				return -1;
			}
			if(s1.length() > s2.length()) {
				return 1;
			}
			return 0;
		});
		
		// Faz a mesma coisa que o metodo compare de cima e da classe ComparadorPorTamanho
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		System.out.println(palavras);
		
		System.out.println("---------------------------------------");
		
		palavras.sort((s1, s2) -> (s1.length() < s2.length()) ? -1 : ((s1.length() == s2.length() ? 0 : 1)));
	
		System.out.println(palavras);
		
		System.out.println("---------------------------------------");
		
		// você pode ter um método default que é estático. Esse é o caso do Comparator.comparing,
		// que é uma fábrica, uma factory, de Comparator. Passamos o lambda para dizer qual
		// será o critério de comparação desse Comparator
		
		/// Então neste caso, a cada interação deste ordenaento a palavra em cada indice vai ser
		// tranformado em uma inteiro com base em quantos caracteres tem a string do laço atual.
		// E o criteiro de comparação é o padrão.
		palavras.sort(Comparator.comparing(s -> s.length()));
		// this::length - Sendo this a string do laço
		// Fazemos uma referência ao método (method reference)
		palavras.sort(Comparator.comparing(String::length));
		Comparator<String> comparadorDeStrings = Comparator.comparing(s -> s.length());
		palavras.sort(comparadorDeStrings);
		
		// Dado uma string ele vai devolver uma integer.
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparadorDeStrings2 = Comparator.comparing(funcao);
		
		Function<String, Integer> semLambda = new Function<String, Integer>() {

			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
	}

}

// Com a Interface Comparator nos podemos criar um nova class que implementa um metodo em que nos 
// podemos alterar o critério de comparação
class ComparadorPorTamanho implements Comparator<String> {

	// O contrato da interface Comparator diz que devemos devolver um número negativo se o primeiro
	// objeto for menor que o segundo, um número positivo caso contrário e zero se forem equivalentes.
	// Exemplo, se a lista em que eu passo tem 3 items e os items são a, ccc e bb, nesta ordem mesmo
	// e eu quero testar pelo length da string, ele vai testar a primeira string com a segunda 
	// depois a primera com a terceira, depos a segunda com a terceira e me retornar uma ordenação
	// com base no length de cada string.
	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length()) {
			return -1;
		}
		if(s1.length() > s2.length()) {
			return 1;
		}
		return 0;
	}
	
}

class ImprimeNaLinha implements Consumer<String> {

	// Toda a vez em que eu vou consumir uma string ele deve fazer alguma coisa... No caso sysout :)
	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}